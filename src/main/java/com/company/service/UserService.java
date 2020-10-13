package com.company.service;

import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);

		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}

		return user.orElse(new User());
	}

	public User findUserById(Long userId) {
		Optional<User> userFromDb = userRepository.findById(userId);
		return userFromDb.orElse(new User());
	}

	public Iterable<User> allUsers() {
		return userRepository.findAll();
	}

	public boolean saveNewUser(User user) {
		Optional<User> userFromDB = userRepository.findByUsername(user.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if (userFromDB.isPresent()) {
			return false;
		}
		userRepository.save(user);
		return true;
	}
	public boolean updateUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return true;
	}



	public void deleteUser(Long userId) {
		if (userRepository.findById(userId).isPresent()) {
			userRepository.deleteById(userId);
		}
	}

}
