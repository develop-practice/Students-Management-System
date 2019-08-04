package practice.develop.server.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertRequestBody {

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
	
	/** 氏名 */
	@Size(max = 100)
	@NotNull
	private String name;

}
