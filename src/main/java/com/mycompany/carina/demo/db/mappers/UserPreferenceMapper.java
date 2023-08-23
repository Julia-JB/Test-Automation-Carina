package com.mycompany.carina.demo.db.mappers;

import com.mycompany.carina.demo.db.models.UserPreference;

public interface UserPreferenceMapper {

	void create(UserPreference userPreference);

	UserPreference findById(Long id);
}
