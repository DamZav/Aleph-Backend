package com.stella.alephart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stella.alephart.models.UserProfile;
import com.stella.alephart.services.UserProfileService;

@RestController
@RequestMapping("/api/userProfile")
public class UserProfileController {

	@Autowired
	private UserProfileService userProfileService;
	
	@GetMapping
    public List<UserProfile> getAllUserProfiles() {
        return userProfileService.findAllUsersProfiles();
    }
	
	 @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        Optional<UserProfile> userProfile = userProfileService.findUserById(id);
        return userProfile.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }
	
	 @PostMapping
    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile savedProfile = userProfileService.saveUserProfile(userProfile);
        return ResponseEntity.ok(savedProfile);
    }
	 
	 @PutMapping("/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long id, 
                                                         @RequestBody UserProfile updatedProfile) {
        Optional<UserProfile> updated = userProfileService.updateUserProfile(id, updatedProfile);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    } 
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
	        Optional<UserProfile> userProfile = userProfileService.findUserById(id);
	        if (userProfile.isPresent()) {
	            userProfileService.deleteUserProfile(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } 
	 
	 
}
