package com.themockmaster.tmmpayment.paystackmodels;

import java.util.HashMap;

public class Data_2 {

	
	   private Long id;
	   private String domain;
	   private String status;
	   private String reference;
	   private String amount;
	   private String message;
	   private String gateway_response;
	   private String paid_at;
	   private String created_at;
	   private String channel;
	   private String currency;
	   private String ip_address;
	   private String metadata;
	   private TransLog log;
	   
	   private Integer fees;
	   private Integer fees_split;
	   private Authorization authorization;
	   private Customer customer;
	   
	    private String plan;
        private Object split;
        private Integer order_id;
        private String paidAt;
        private String createdAt;
        private Integer requested_amount;
        
        
        public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDomain() {
			return domain;
		}
		public void setDomain(String domain) {
			this.domain = domain;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getReference() {
			return reference;
		}
		public void setReference(String reference) {
			this.reference = reference;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getGateway_response() {
			return gateway_response;
		}
		public void setGateway_response(String gateway_response) {
			this.gateway_response = gateway_response;
		}
		public String getPaid_at() {
			return paid_at;
		}
		public void setPaid_at(String paid_at) {
			this.paid_at = paid_at;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getIp_address() {
			return ip_address;
		}
		public void setIp_address(String ip_address) {
			this.ip_address = ip_address;
		}
		public String getMetadata() {
			return metadata;
		}
		public void setMetadata(String metadata) {
			this.metadata = metadata;
		}
		
		public TransLog getLog() {
			return log;
		}
		public void setLog(TransLog log) {
			this.log = log;
		}
		public Integer getFees() {
			return fees;
		}
		public void setFees(Integer fees) {
			this.fees = fees;
		}
		public Integer getFees_split() {
			return fees_split;
		}
		public void setFees_split(Integer fees_split) {
			this.fees_split = fees_split;
		}
		public Authorization getAuthorization() {
			return authorization;
		}
		public void setAuthorization(Authorization authorization) {
			this.authorization = authorization;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public String getPlan() {
			return plan;
		}
		public void setPlan(String plan) {
			this.plan = plan;
		}
		public Object getSplit() {
			return split;
		}
		public void setSplit(Object split) {
			this.split = split;
		}
		public Integer getOrder_id() {
			return order_id;
		}
		public void setOrder_id(Integer order_id) {
			this.order_id = order_id;
		}
		public String getPaidAt() {
			return paidAt;
		}
		public void setPaidAt(String paidAt) {
			this.paidAt = paidAt;
		}
		public String getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(String createdAt) {
			this.createdAt = createdAt;
		}
		public Integer getRequested_amount() {
			return requested_amount;
		}
		public void setRequested_amount(Integer requested_amount) {
			this.requested_amount = requested_amount;
		}
		public Object getPos_transaction_data() {
			return pos_transaction_data;
		}
		public void setPos_transaction_data(Object pos_transaction_data) {
			this.pos_transaction_data = pos_transaction_data;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public Object getFees_breakdown() {
			return fees_breakdown;
		}
		public void setFees_breakdown(Object fees_breakdown) {
			this.fees_breakdown = fees_breakdown;
		}
		public String getTransaction_date() {
			return transaction_date;
		}
		public void setTransaction_date(String transaction_date) {
			this.transaction_date = transaction_date;
		}
		public Object getPlan_object() {
			return plan_object;
		}
		public void setPlan_object(Object plan_object) {
			this.plan_object = plan_object;
		}
		public Object getSubaccount() {
			return subaccount;
		}
		public void setSubaccount(Object subaccount) {
			this.subaccount = subaccount;
		}
		private Object pos_transaction_data;
        private String source;
        private Object fees_breakdown;
        private String transaction_date;
        private Object plan_object;
        private Object subaccount;
}
