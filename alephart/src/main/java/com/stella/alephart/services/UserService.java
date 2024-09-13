package com.stella.alephart.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stella.alephart.models.User;
import com.stella.alephart.repository.UserRepository;


@Service
public class UserService {
	// Inyección de dependencias
	@Autowired
	private UserRepository userRepository;
	
	//public List<User> findAllUsers(){
	//	return userRepository.findAll();
	//}
	
	public Optional<User> findUserById(Long id){
		return userRepository.findById(id);
	}
		
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(Long id, User user) {
		Optional<User> existingUserOptional = userRepository.findById(id);
		
		if (existingUserOptional.isPresent()) {
			User existingUser = existingUserOptional.get();
			// Actualizar datos de usuario === JUST IN CASE ===
			//existingUser.setFirst_name(user.getFirst_name());
			//existingUser.setLast_name(user.getLast_name());
			//existingUser.setEmail(user.getEmail());
			//existingUser.setPhone_number(user.getPhone_number());
			existingUser.setPassword(user.getPassword());
			
			return userRepository.save(user);
		} else {
			throw new RuntimeException("Usuario no encontrado");
		}
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
