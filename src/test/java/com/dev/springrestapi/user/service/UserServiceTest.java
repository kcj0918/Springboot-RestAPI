//package com.dev.springrestapi.user.service;
//
//import com.dev.springrestapi.user.domain.User;
//import com.dev.springrestapi.user.dto.request.user.UserAddRequestDto;
//import com.dev.springrestapi.user.repository.UserRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @AfterEach
//    public void tearDown() {
//        userRepository.deleteAll();
//    }
//
//    @Test
//    public void addUserTest() {
//        //given
//        UserAddRequestDto userAddRequestDto = UserAddRequestDto.builder()
//                .email("add test email")
//                .name("add test name")
//                .build();
//        User addUser = User.builder()
//                .email(userAddRequestDto.getEmail())
//                .name(userAddRequestDto.getName())
//                .build();
//        userRepository.save(addUser);
//
//        //when
//        userService.addUser(userAddRequestDto);
//
//        //then
//        verify(userRepository).save(addUser);
//    }
//
//    @Test
//    public void getUserByEmailTest() {
//        //given
//        User user = User.builder()
//                .email("get test email")
//                .name("get test name")
//                .build();
//        userRepository.save(user);
//        when(userService.getUserByEmail("get test email")).thenReturn(user);
//
//        //when
//        User getUser = userService.getUserByEmail(user.getEmail());
//
//        //then
//        verify(userRepository).getUserByEmail(getUser.getEmail());
//    }
//}
