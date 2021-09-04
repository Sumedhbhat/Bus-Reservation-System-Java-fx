package application;
	
import javafx.application.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import java.sql.*;
import javafx.scene.control.TableView;
import javafx.collections.*;
import javafx.beans.*;

public class Main extends Application {
	int verify=0;
	int value=0;
	Font font = Font.font("Arial", 14);
	Font fon = Font.font("Arial", 18);
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		
		//Setting the Primary Stage
		primaryStage.setTitle("Transport Management System");
		GridPane root=new GridPane();
		
		
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25,25,25,25));
		

		Scene scene=new Scene(root,400,400);
		primaryStage.setScene(scene);
		
		
		Label l=new Label("Login Details");
		Label username=new Label("User");
		Label Password=new Label("Password");
		TextField t1=new TextField();
		TextField t2=new TextField();
		Button submit=new Button("Login");
		Button create=new Button("Create User");
		Button close=new Button("Close");
		
		root.add(l,0,1);
		l.setFont(fon);
		l.setWrapText(true);
		
		root.add(username, 0, 2);
		username.setFont(font);
		
		root.add(Password, 0, 3);
		Password.setFont(font);
		
		Label l1=new Label();
		l1.setFont(font);
		
		root.add(t1, 1, 2);
		t1.setFont(font);
		
		root.add(t2, 1, 3);
		t2.setFont(font);
		
		
		root.add(submit, 1, 4);
		submit.setFont(font);
		
		
		root.add(create, 1,	5);
		create.setFont(font);
		
		root.add(close, 1,6);
		close.setFont(font);
		

		root.add(l1, 1, 7);
		l1.setFont(font);
		
		create.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				// TODO Auto-generated method stub
				try {
					Class c1=Class.forName("com.mysql.cj.jdbc.Driver");

					final String JdbcDriver="com.mysql.cj.jdbc.Driver";
					final String user="root";
					final String pass="password";
					final String db_url="jdbc:mysql://127.0.0.1:3306/transport";
					Connection con=DriverManager.getConnection(db_url,user,pass);
					String query="Insert into users values (?,?);";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, t1.getText());
					ps.setString(2, t2.getText());
					ps.execute();	
					System.out.println("User Created");
					con.close();
			}
				catch(Exception e){
					
				}
			}
			
		});
		
		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ar) {
				// TODO Auto-generated method stub
				primaryStage.close();
			}
			
		});
		
		
		submit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent ae) {
				// TODO Auto-generated method stub
				try {
					Class c1=Class.forName("com.mysql.cj.jdbc.Driver");

					final String JdbcDriver="com.mysql.cj.jdbc.Driver";
					final String user="root";
					final String pass="password";
					final String db_url="jdbc:mysql://127.0.0.1:3306/transport";
					Connection con=DriverManager.getConnection(db_url,user,pass);
					String query="Select * from users where username=? and password=?;";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, t1.getText());
					ps.setString(2, t2.getText());
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						verify=1;
					}
					con.close();
			}
				catch(Exception e){
					
				}
				if(verify==0)
				{
					//Closes application
					l1.setText("Incorrect Username or Password");
					
				}
				if(verify==1)
				{
					primaryStage.close();
					
					
					Stage Menu=new Stage();
					GridPane menubar=new GridPane();
					menubar.setAlignment(Pos.CENTER);
					menubar.setHgap(10);
					menubar.setVgap(10);
					menubar.setPadding(new Insets(25,25,25,25));
					Scene scene1=new Scene(menubar,400,400);
					Menu.setScene(scene1);
					Menu.setTitle("Menu");
					
					
					Button Reserve=new Button("Reservation");
					Button Cancel=new Button("Cancellation");
					Button Show=new Button("Show all Passengers");
					Button Exit=new Button("Exit");
					
					Reserve.setFont(font);
					Cancel.setFont(font);
					Show.setFont(font);
					Exit.setFont(font);
					
					
					menubar.add(Reserve,0,1);
					menubar.add(Cancel,0,2);
					menubar.add(Show, 0, 3);
					menubar.add(Exit, 0, 4);
					
					Reserve.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent ae) {
							// TODO Auto-generated method stub
							
							Stage res=new Stage();
							GridPane R=new GridPane();
							Scene RScene=new Scene(R,400,400);
							res.setScene(RScene);
							res.setTitle("Reservations");
							
							//Setting all Scene Elements
							R.setAlignment(Pos.CENTER);
							R.setHgap(10);
							R.setVgap(10);
							R.setPadding(new Insets(25,25,25,25));
							
							//Setting all Tables
							Label fname=new Label("First Name");
							Label gender=new Label("Gender");
							Label lname=new Label("Last Name");
							Label start=new Label("Start Point");
							Label end=new Label("Destination");
							Label ph=new Label("Phone Number");
							Label age=new Label("Age");
							Label inform=new Label();
							
							//Inserting Information
							TextField tfname=new TextField();
							TextField tlname=new TextField();
							TextField tage=new TextField();
							TextField tgender=new TextField();
							TextField tstart=new TextField();
							TextField tend=new TextField();
							
							//Setting Fonts
							fname.setFont(font);
							lname.setFont(font);
							start.setFont(font);
							gender.setFont(font);
							ph.setFont(font);
							end.setFont(font);
							age.setFont(font);
							tfname.setFont(font);
							tlname.setFont(font);
							tage.setFont(font);
							tgender.setFont(font);
							tstart.setFont(font);
							tend.setFont(font);
							
							Button submit1=new Button("Submit");
							Button Close=new Button("Cancel Booking");
							
							//Adding all Fields
							R.add(fname, 0, 1);
							R.add(lname,0,2);
							R.add(gender,0, 3);
							R.add(age, 0, 4);
							R.add(start, 0, 5);
							R.add(end, 0, 6);
							R.add(tfname, 1, 1);
							R.add(tlname, 1, 2);
							R.add(tgender, 1, 3);
							R.add(tage,1,4);
							R.add(tstart, 1, 5);
							R.add(tend, 1, 6);
							R.add(submit1,1,7);
							R.add(Close,1,8);
							R.add(inform,1,9);
							
							submit1.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent ae) {
									// TODO Auto-generated method stub
									
									String tbfname = tfname.getText();
									String tblname = tlname.getText();
									String tbgender = tgender.getText();
									String tbage = tage.getText();
									String tbstart=tstart.getText();
									String tbend=tend.getText();
									
									try {
										Class c1=Class.forName("com.mysql.cj.jdbc.Driver");

										final String JdbcDriver="com.mysql.cj.jdbc.Driver";
										final String user="root";
										final String pass="password";
										final String db_url="jdbc:mysql://127.0.0.1:3306/transport";
										Connection con=DriverManager.getConnection(db_url,user,pass);
										
										String query="Select route_id from routes where start=? and dest=?;";
										PreparedStatement st=con.prepareStatement(query);
										st.setString(1,tbstart);
										st.setString(2,tbend);
										ResultSet r=st.executeQuery();
										if(r.next()) {
											value=1;
										}
										if(value==0)
										{
											inform.setText("There are no transports heading there");
											
										}
										if(value==1)
										{
										
										
											String query1= "INSERT INTO passengers VALUES(?,?,?,?,?,?);";
											PreparedStatement ps=con.prepareStatement(query1);
											ps.setString(1,tbfname);
											ps.setString(2,tblname);
											ps.setString(3, tbage);
											ps.setString(4,tbgender);
											ps.setString(5,tbstart);
											ps.setString(6,tbend);
											//ps.executeUpdate();
											
											ps.execute();
											System.out.println("Inserted Successfully");
											String query2="Select bus_no,route_id,price from routes where start=? and dest=?;";
											
											PreparedStatement stmt=con.prepareStatement(query2);
											stmt.setString(1,tbstart);
											stmt.setString(2,tbend);
											ResultSet rs=stmt.executeQuery();
											while(rs.next()) {
												System.out.println("BUS NO : "+rs.getString(1)+"\n Route ID : "+rs.getString(2)+"\n Price : "+rs.getString(3));
											}
											
											con.close();
											
											res.close();
										}
									}
										catch(SQLException e)
										{
											e.printStackTrace();
										}
									catch(Exception e)
									{
										System.out.println(e);
									}
								}
								
							});
							
							Close.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent ae) {
									// TODO Auto-generated method stub
									res.close();
								}
								
							});
							
							
							res.show();
							
						}
						
					});
					Cancel.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent ae) {
							// TODO Auto-generated method stub
							
							Stage Cancel=new Stage();
							Cancel.setTitle("Cancellations");
							GridPane root2=new GridPane();
							Scene scene=new Scene(root2,400,400);
							Cancel.setScene(scene);
							
							root2.setAlignment(Pos.CENTER);
							root2.setHgap(10);
							root2.setVgap(10);
							root2.setPadding(new Insets(25,25,25,25));
							
							Label passen=new Label("Passenger Name");
							Label rid=new Label("Route ID");
							
							TextField t1=new TextField();
							TextField t2=new TextField();
							
							Button Can=new Button("Cancel"); 
							
							root2.add(passen, 0, 1);
							root2.add(rid, 0, 2);
							root2.add(t1, 1, 1);
							root2.add(t2, 1, 2);
							root2.add(Can,1,3);
							
							Can.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent ae) {
									// TODO Auto-generated method stub
									try {
										Class c1=Class.forName("com.mysql.cj.jdbc.Driver");

										final String JdbcDriver="com.mysql.cj.jdbc.Driver";
										final String user="root";
										final String pass="password";
										final String db_url="jdbc:mysql://127.0.0.1:3306/transport";
										Connection con=DriverManager.getConnection(db_url,user,pass);
										
										String query="delete from passengers where Start=Any(select start from routes) and Dest=Any(select dest from routes) and Fname=?; ";
										PreparedStatement ps=con.prepareStatement(query);
										ps.setString(1,t1.getText());
										ps.execute();
										System.out.println("Passenger Booking Cancelled");
										Cancel.close();
										
										}
									
										catch(Exception e)
										{
											
										}
								}
								
							});
							
							Cancel.show();
						}
						
					});
							Show.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent ae) {
									try {
										Class c1=Class.forName("com.mysql.cj.jdbc.Driver");

										final String JdbcDriver="com.mysql.cj.jdbc.Driver";
										final String user="root";
										final String pass="password";
										final String db_url="jdbc:mysql://127.0.0.1:3306/transport";
										Connection con=DriverManager.getConnection(db_url,user,pass);
										File fw=new File("Passengers.txt");
										FileWriter f=new FileWriter(fw);
										PrintWriter pw=new PrintWriter(f);
										Statement stmt=con.createStatement();
										String query="select * from passengers;";
										ResultSet rs=stmt.executeQuery(query);
										System.out.println("Firstname LastName Age Gender Boarding Point Destination");
										pw.println("Firstname LastName Age Gender Boarding Point Destination");
										while(rs.next()) {
											System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"  \t  "+rs.getString(3)+"   \t  "+rs.getString(4)+"  \t  "+rs.getString(5)+"  \t   "+rs.getString(6));
											pw.println(rs.getString(1)+"\t"+rs.getString(2)+"  \t  "+rs.getString(3)+"   \t  "+rs.getString(4)+"  \t  "+rs.getString(5)+"  \t   "+rs.getString(6));
										}
										pw.close();
										}
										catch(Exception e)
										{
											
										}
									
										
								}
								
							});
						Exit.setOnAction(new EventHandler<ActionEvent>() {
						
							public void handle(ActionEvent ae) {
								Menu.close();
								primaryStage.close();
							}
						});
					
					Menu.show();
				}
				
			}
			
		});
		
		primaryStage.show();
	}
	
	
	
}
