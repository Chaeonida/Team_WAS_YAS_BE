package org.prgrms.yas.domain.routine.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineStatusCreateRequest {
	private Long routineStatusId;
	private String content;
	private Integer emoji;
	private List<Long> deletedImages = new ArrayList<>();
	private List<String> reviewImages = new ArrayList<>();
	
	public RoutineStatusCreateRequest(Long routineStatusId, String content, Integer emoji, List<Long> deletedImages ,List<String> reviewImages){
		this.routineStatusId = routineStatusId;
		this.content = content;
		this.emoji = emoji;
		this.deletedImages = deletedImages;
		this.reviewImages = reviewImages;
	}
	
	public void setReviewImages(String reviewImages) {
		this.reviewImages.add(reviewImages);
	}
}
