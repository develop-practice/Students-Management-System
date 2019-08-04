package practice.develop.server.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectResponseBody {

	/** 学年 */
	private int schoolYear;

	/** クラス */
	private int schoolClass;
	
	/** 出席番号 */
	private int attendanceNumber;
	
	/** 氏名 */
	private String name;
	
	/** リザルトメ�?セージ */
	private String resultMessage;
	
}
