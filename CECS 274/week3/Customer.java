package week3;

public class Customer {
	
	//Instance Variables: attributes of the CustomerTester object
	//CustomerID, rewardsPts, membershipLvl
	
	private int customerID;
	private int rewardsPts;
	private String membershipLvl;
	
	/**
	 * default constructor, takes integer for customerID; initializes rewardsPts and membershipLvl
	 * @param customerID - the ID of this customer as an int
	 * **/
	public Customer(int customerID) {
		this.customerID = customerID;
		rewardsPts = 0;
		membershipLvl = ""; }
	/**
	 * overloaded constructor initializes object with present data
	 * @param customerID - the ID of this customer as an int
	 * @param rewardsPts - rewards points as an int
	 * **/
	public Customer(int customerID, int rewardsPts) {
		this.customerID = customerID;
		this.rewardsPts = rewardsPts;
		membershipLvl = ""; }
	/**
	 * Determines what membershipLvl a customer is
	 * **/
	public void membership() {
		if (rewardsPts >= 0 && rewardsPts <= 2000) {
			membershipLvl = "Bronze"; }
		if (rewardsPts >= 2001 && rewardsPts <= 5000) {
			membershipLvl = "Silver"; }
		if (rewardsPts >= 5001 && rewardsPts <= 10000) {
			membershipLvl = "Gold"; }
		if (rewardsPts > 10000) {
			membershipLvl = "Platinum"; } }
	/**
	 * adds more reward points
	 * @param newPoints - new amount of points to add to current points
	 * **/
	public void addPoints(int newPoints) {
		rewardsPts = rewardsPts + newPoints; }
	/**
	 * gets the customer ID
	 * @return the customerID as an int
	 * **/
	public int getCustomerID() {
		return customerID; }
	/**
	 * gets the rewards points
	 * @return the rewardsPts as an int
	 * **/
	public int getRewardsPts() {
		return rewardsPts; }
	/**
	 * gets the membership level
	 * @return membershipLvl as a String
	 * **/
	public String getMembershipLvl() {
		return membershipLvl; }
	/**
	 * tells compiler what to print instead of the object address
	 * @return formatted string with the information of this current object
	 * **/
	public String toString() {
		this.membership();
		String info = String.format("Customer ID: %d%nRewards Points: %d%nMembership Level: %s", this.customerID, this.rewardsPts, this.membershipLvl);
		return info; } }