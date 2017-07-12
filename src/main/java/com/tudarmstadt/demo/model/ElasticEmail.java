package com.tudarmstadt.demo.model;

import java.util.List;

import org.jongo.marshall.jackson.oid.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "search")
public class ElasticEmail {	  

	  @Id
	  @ObjectId
	  private String id;
	  
	  private String docid;

	  private String sender;

	  private List<String> recipients;

	  private List<String> cc;

	  private String text;

	  private String mid;

	  private String fpath;

	  private List<String> bcc;

	  private List<String> to;

	  private String replyto;

	  private String ctype;

	  private String fname;

	  private String date;

	  private String folder;

	  private String subject;

	  
	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public String getDocid() {
			return docid;
		}

		public void setDocid(String docid) {
			this.docid = docid;
		}

		public String getSender() {
			return sender;
		}

		public void setSender(String sender) {
			this.sender = sender;
		}

		public List<String> getRecipients() {
			return recipients;
		}

		public void setRecipients(List<String> recipients) {
			this.recipients = recipients;
		}

		public List<String> getCc() {
			return cc;
		}

		public void setCc(List<String> cc) {
			this.cc = cc;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getFpath() {
			return fpath;
		}

		public void setFpath(String fpath) {
			this.fpath = fpath;
		}

		public List<String> getBcc() {
			return bcc;
		}

		public void setBcc(List<String> bcc) {
			this.bcc = bcc;
		}

		public List<String> getTo() {
			return to;
		}

		public void setTo(List<String> to) {
			this.to = to;
		}

		public String getReplyto() {
			return replyto;
		}

		public void setReplyto(String replyto) {
			this.replyto = replyto;
		}

		public String getCtype() {
			return ctype;
		}

		public void setCtype(String ctype) {
			this.ctype = ctype;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getFolder() {
			return folder;
		}

		public void setFolder(String folder) {
			this.folder = folder;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}		

}
