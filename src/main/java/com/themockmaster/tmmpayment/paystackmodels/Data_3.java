package com.themockmaster.tmmpayment.paystackmodels;

import java.util.List;

public class Data_3 {

	

		private Long   id;
		private String domain;
		private String amount;
		private String currency;
		private String due_date;
		private boolean has_invoice;
		private Long invoice_number;
		private String description;
		private String pdf_url;
		private List<Object> line_items;
		private List<Object>  tax;
		private String request_code;
		private String status;
		private boolean paid;
		private String paid_at;
		private String metadata;
		private List<Object> notifications;
		
		
		
		private String offline_reference;
		@Override
		public String toString() {
			return "Data_3 [id=" + id + ", domain=" + domain + ", amount=" + amount + ", currency=" + currency
					+ ", due_date=" + due_date + ", has_invoice=" + has_invoice + ", invoice_number=" + invoice_number
					+ ", description=" + description + ", pdf_url=" + pdf_url + ", line_items=" + line_items + ", tax="
					+ tax + ", request_code=" + request_code + ", status=" + status + ", paid=" + paid + ", paid_at="
					+ paid_at + ", metadata=" + metadata + ", notifications=" + notifications + ", offline_reference="
					+ offline_reference + ", customer=" + customer + ", created_at=" + created_at + "]";
		}
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
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getDue_date() {
			return due_date;
		}
		public void setDue_date(String due_date) {
			this.due_date = due_date;
		}
		public boolean isHas_invoice() {
			return has_invoice;
		}
		public void setHas_invoice(boolean has_invoice) {
			this.has_invoice = has_invoice;
		}
		public Long getInvoice_number() {
			return invoice_number;
		}
		public void setInvoice_number(Long invoice_number) {
			this.invoice_number = invoice_number;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPdf_url() {
			return pdf_url;
		}
		public void setPdf_url(String pdf_url) {
			this.pdf_url = pdf_url;
		}
		public List<Object> getLine_items() {
			return line_items;
		}
		public void setLine_items(List<Object> line_items) {
			this.line_items = line_items;
		}
		public List<Object> getTax() {
			return tax;
		}
		public void setTax(List<Object> tax) {
			this.tax = tax;
		}
		public String getRequest_code() {
			return request_code;
		}
		public void setRequest_code(String request_code) {
			this.request_code = request_code;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isPaid() {
			return paid;
		}
		public void setPaid(boolean paid) {
			this.paid = paid;
		}
		public String getPaid_at() {
			return paid_at;
		}
		public void setPaid_at(String paid_at) {
			this.paid_at = paid_at;
		}
		public String getMetadata() {
			return metadata;
		}
		public void setMetadata(String metadata) {
			this.metadata = metadata;
		}
		public List<Object> getNotifications() {
			return notifications;
		}
		public void setNotifications(List<Object> notifications) {
			this.notifications = notifications;
		}
		public String getOffline_reference() {
			return offline_reference;
		}
		public void setOffline_reference(String offline_reference) {
			this.offline_reference = offline_reference;
		}
		public String getCustomer() {
			return customer;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		private String customer;
		private String created_at;

	
	
	
}
