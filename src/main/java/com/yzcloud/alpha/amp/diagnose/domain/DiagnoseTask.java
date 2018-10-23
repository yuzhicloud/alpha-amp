package com.yzcloud.alpha.amp.diagnose.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Diagnose Task
 */

@Entity
@Table( name = "alpha_diagnose_task")
public class DiagnoseTask implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@NotNull
	@Size( min=30 , max=60)
	@Column( name="task_title", length=60, nullable=false )
	private String taskTitle;
	
	@Column( name="start_time")
	private String startTime;
	
	@Column ( name="end_time" )
	private String endTime;
	
	@Column( name="exec_status")
	private boolean status;
	
	@Column( name="task_type")
	private DiagnoseTaskTypeEnum taskType;
	
	private String expectResult;
	
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskTitle() {
		return taskTitle;
	}
	
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public DiagnoseTaskTypeEnum getTaskType() {
		return taskType;
	}
	
	public void setTaskType(DiagnoseTaskTypeEnum taskType) {
		this.taskType = taskType;
	}
	
	public String getExpectResult() {
		return expectResult;
	}
	
	public void setExpectResult(String expectResult) {
		this.expectResult = expectResult;
	}
	
	@Override
	public String toString(){
		return "DiagnoseTask{" +
			"id='" + taskId+ '\'' +
			", title='" + taskTitle+ '\'' +
			", type='" + taskType+ '\'' +
			", status='" + status+ '\'' +
			", startTime='" + startTime+ '\'' +
			", endTime='" + endTime+ '\'' +
			", expectResult='" + expectResult+ '\'' +
			"}";
	}
}
