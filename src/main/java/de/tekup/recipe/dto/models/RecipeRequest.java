package de.tekup.recipe.dto.models;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import de.tekup.recipe.data.models.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeRequest {

	private Long id;

	@NotBlank(message = "Give a propre description")
	@Size(min = 5, max = 50)
	private String description;

	@Positive
	private Integer servings;

	private LocalTime prepTime = LocalTime.of(0, 0);

	private LocalTime cookTime = LocalTime.of(0, 0);;

	private Difficulty difficulty;
	
	@NotBlank
	private String directions;
	
	public String getPrepTimeTH() {
		return prepTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public String getCookTimeTH() {
		return cookTime.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public void setPrepTimeTH(String time) {
		prepTime = LocalTime.parse(time);
	}
	
	public void setCookTimeTH(String time) {
		cookTime = LocalTime.parse(time);
	}

}
