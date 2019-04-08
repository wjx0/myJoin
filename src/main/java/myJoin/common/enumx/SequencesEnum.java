package myJoin.common.enumx;
/**
 * 序列
 * @author x
 *
 */
public enum SequencesEnum {
	ADVICE("ADVICE","SEQ_ADVICE"),
	MESSAGE("MESSAGE","SEQ_MESSAGE"),
	ROLE("ROLE","SEQ_ROLE"),
	SYS_ACTION_LOG("SYS_ACTION_LOG","SEQ_SYS_ACTION_LOG"),
	USER_ROLE("USER_ROLE","SEQ_USER_ROLE"),
	NOTICE("NOTICE","SEQ_NOTICE");
	
	/** 表名 **/
	private String tableName;
	/** 序列名**/
	private String sequencesName;
	
	SequencesEnum(String tableName,String sequencesName) {
		this.tableName = tableName;
		this.sequencesName = sequencesName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSequencesName() {
		return sequencesName;
	}

	public void setSequencesName(String sequencesName) {
		this.sequencesName = sequencesName;
	}
	
}
