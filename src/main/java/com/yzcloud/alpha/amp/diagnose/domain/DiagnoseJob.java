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
public class DiagnoseJob implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long jobId;
	
	@NotNull
	@Size( min=30 , max=60)
	@Column( name="node_ip", length=60, nullable=false )
	private String nodeIpAddr;
	
	@Column( name="protocol")
	private String protocol;
	
	@Column( name="result")
	private String result;
	
	@Column( name="issues")
	private String issues;
	
	public DiagnoseJob(){}
	
	public DiagnoseJob(String nodeIpAddr,
	                   String protocol,
	                   String result
	                    ){
		this.nodeIpAddr = nodeIpAddr;
		this.protocol = protocol;
		this.result = result;
	}
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	public long getJobId() {
		return jobId;
	}
	
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	
	public String getNodeIpAddr() {
		return nodeIpAddr;
	}
	
	public void setNodeIpAddr(String nodeIpAddr) {
		this.nodeIpAddr = nodeIpAddr;
	}
	
	public String getProtocol() {
		return protocol;
	}
	
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getIssues() {
		return issues;
	}
	
	public void setIssues(String issues) {
		this.issues = issues;
	}
	
	@Override
	public String toString(){
		return "DiagnoseJob{" +
			"id='" + jobId + '\'' +
			", nodeIpAddr='" + nodeIpAddr+ '\'' +
			", protocol='" + protocol+ '\'' +
			", result='" + result+ '\'' +
			"}";
	}
}
