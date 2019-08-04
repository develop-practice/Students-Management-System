package practice.develop.blank.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectRequestBody {

	/** 学年 */
	@Min(1)
	@Max(3)
	private int schoolYear;

	/** クラス */
	@Min(1)
	@Max(6)
	private int schoolClass;
	
	/** 出席番号 */
	@Min(1)
	private int attendanceNumber;

}
