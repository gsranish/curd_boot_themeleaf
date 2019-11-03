package com.gsr.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.gsr.demo.controller.UserController;
import com.gsr.demo.entity.User;
import com.gsr.demo.repo.UserRepository;

public class UserControllerUnitTest {
	
	private static UserController userController;
	private static UserRepository mockeduserRepo;
	private static BindingResult mockedResult;
	private static Model mockedModel;
	
	@BeforeTestClass
	public static void setUpUserControllerInsatance() {
		mockeduserRepo=mock(UserRepository.class);
		mockedResult=mock(BindingResult.class);
		mockedModel=mock(Model.class);
		userController=new UserController(mockeduserRepo);
		
	}
	
	@Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        User user = new User("John","john@domain.com");
        assertThat(userController.showSignUpForm(user)).isEqualTo("add-user");
    }
    
    @Test
    public void whenCalledaddUserAndValidUser_thenCorrect() {
        User user = new User("John","john@domain.com");
        when(mockedResult.hasErrors()).thenReturn(false);
        assertThat(userController.addUser(user, mockedResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledaddUserAndInValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedResult.hasErrors()).thenReturn(true);
        assertThat(userController.addUser(user, mockedResult, mockedModel)).isEqualTo("add-user");
    }

    @Test
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(userController.showUpdateForm(0, mockedModel)).isEqualTo("update-user");
    }
    
    @Test
    public void whenCalledupdateUserAndValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedResult.hasErrors()).thenReturn(false);
        assertThat(userController.updateUser(1l, user, mockedResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledupdateUserAndInValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedResult.hasErrors()).thenReturn(true);
        assertThat(userController.updateUser(1l, user, mockedResult, mockedModel)).isEqualTo("update-user");
    }
    
    @Test
    public void whenCalleddeleteUser_thenIllegalArgumentException() {
        assertThat(userController.deleteUser(1l, mockedModel)).isEqualTo("index");
    }

}
