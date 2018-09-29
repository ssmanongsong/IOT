<?php

	class DbOperation{
	
		private $con;

		function __construct(){
			
			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();
		}
		
		public function userLogin($Email, $Password){
			$Password = md5($Password);
			$stmt = $this->con->prepare("SELECT id FROM users WHERE Email = ? AND Password = ?");
			$stmt->bind_param("ss",$Email,$Password);
			$stmt->execute();
			$stmt->store_result();
			return $stmt->num_rows > 0;
		}

		public function getUserByEmail($Email){
			$stmt = $this->con->prepare("SELECT * FROM users WHERE Email = ?");
			$stmt->bind_param("s",$Email);
			return $stmt->get_result()->fetch_assoc();
		}
		function createUser($Email, $Password){
			$Password = md5($Password);
			$stmt = $this->con->prepare("INSERT INTO 'users' ('id', 'Email', 'Password', 'QR Code', 'Account Balance', 'Reward Points', 'User Type') VALUES (NULL,?,?,1,0,0,?);");
			$stmt->bind_param("sss",$username,$password,$email);

			if($stmt->execute()){
				return true;
			}else{
				return false;
			}
		}
	}