package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.publisherdata.model.Article;
import com.publisherdata.model.DashboardTemplate;
import com.publisherdata.model.DropdownMap;
import com.publisherdata.model.Section;
import com.publisherdata.model.Site;
import com.publisherdata.model.TemplateMap;
import com.publisherdata.model.TimeSpanMap;

public class GetMiddlewareData {

	/*
	 public static Map<String,String> sectionMap;
	  public static Map<String,String> articleMap;
	  public static Map<String,String> siteMap;
	  
	  
	  static {
	      Map<String, String> siteMap1 = new HashMap<String,String>();
	      List<Site> sitedata = GetMiddlewareData.getSiteData("1");
	     
	      try {

	         
	         
	        for(Site site: sitedata){

	             try{
	          	 siteMap.put(site.getSiteId(),site.getSiteName());
	             }
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 

	      
	      siteMap = Collections.unmodifiableMap(siteMap);  
	  
	      //    System.out.println(citycodeMap);
	  }
	
	  

	  static {
	      Map<String, String> sectionMap1 = new HashMap<String,String>();
	      for (Map.Entry<String, String> entry : siteMap.entrySet())
	      {
	       
	      List<Site> sitedata = GetMiddlewareData.getSiteData(entry.getKey());
	     
	      try {

	         
	         
	        for(Site site: sitedata){
	             
	        	try{
	          	 sectionMap1.put(site.getSiteId(),site.getSiteName());
	        	}
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 
	      
	      }
	      
	      sectionMap = Collections.unmodifiableMap(sectionMap1);  
	  
	      //    System.out.println(citycodeMap);
	  }
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  static {
	      Map<String, String> articleMap1 = new HashMap<String,String>();
	      for (Map.Entry<String, String> entry : siteMap.entrySet())
	      {
	       
	      List<Article> articledata = GetMiddlewareData.getArticleData(entry.getKey());
	     
	      try {

	         
	         
	        for(Article article: articledata){

	             try{
	          	 articleMap1.put(article.getId(), article.getArticleName());
	             }
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 
	      
	      }
	      
	      articleMap = Collections.unmodifiableMap(articleMap1);  
	  
	      //    System.out.println(citycodeMap);
	  }
	 
	  
	  */
	  
	  
	  
	  
	  
	  
	  
	  
	  
	public static void main(String[] args) throws IOException {
		
	//	String mobilesId = "Sony E5653 Xperia M5 2015_september";
		
	//	GetMiddlewareData.get91mobilesData(mobilesId); 
		GetMiddlewareData.getSiteData("1");
	}
	
	
	
  

   public static List<Section> getSectionData( String siteid) {
	   
	    String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String sectionid = null;
	    String sectionurl = null;
	   
	    query0 = "Select * from Section where siteid="+siteid;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
		try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				sectionid = rs.getString("Id");
			    sectionurl = rs.getString("SectionUrl");
			     System.out.println(sectionurl);
	             Section obj = new Section();
	             obj.setSiteId(siteid);
	             obj.setSectionUrl(sectionurl);
	    		 obj.setId(sectionid);
	    	     section.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	      
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	    
		
	        
	    return section;
		 
  }
   
     



   public static List<Article> getArticleData( String siteid ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "Qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	    String articlename = null;
	 	    query0 = "Select * from Article where siteid="+siteid;
	 	    
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 		try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				articlename = rs.getString("ArticleName");
	 				System.out.println(articleurl);
	 	             Article obj = new Article();
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setSiteId(siteid);;
	 	    	     obj.setArticleName(articlename);
	 	    		 article.add(obj);
	 	    	
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}   
	 	         
	 	        
	 	    return article;
		 
 }
  
   public static Article getArticleMetaData( String url ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	    String articlename = null;
	 	    String articletitle = null;
	 	    String siteid = null;
	 	    String author = null;
	 	    String publishdate = null;
	 	    String mainimage = null;
	 	    String tag = null;
	 	    String authorId = null;
	 	    query0 = "Select * from Article where ArticleUrl like '%"+url+"%'";
	 	    Article obj = new Article();
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 		try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				articlename = rs.getString("ArticleName");
	 				siteid = rs.getString("SiteId");
	 			    publishdate = rs.getString("PublishDate");
	 			    articletitle = rs.getString("ArticleTitle");
	 			    author = rs.getString("Author");
	 			    mainimage = rs.getString("MainImage");
	 			    tag =rs.getString("Tags");
	 				authorId = rs.getString("AuthorId");
	 			    System.out.println(articleurl);
	 			    List<String> tags1 = Arrays.asList(tag.split("\\s*,\\s*")); 
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setSiteId(siteid);;
	 	    	     obj.setArticleName(articlename);
	 	    		 obj.setAuthor(author);
	 	    		 obj.setPublishdate(publishdate);
	 	    		 obj.setMainimage(mainimage);
	 	    		 obj.setTag(tag);
	 	    	     obj.setArticletitle(articletitle);
	 	    		// article.add(obj);
	 	    	     obj.setAuthorId(authorId);
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}   
	 	         
	 	        
	 	    return obj;
		 
 }
  
	    
   public static Article getArticleName( String articleId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "Qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	   
	 	    query0 = "Select * from Article where Id="+articleId;
	 	    
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 	     Article obj = new Article();
	 	     
	 	     try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				
	 				System.out.println(articleurl);
	 	             
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setArticleName(rs.getString("ArticleName"));
	 	    	    
	 	    	
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}    
	 	         
	 	        
	 	    return obj;
		 
 }


   public static Section getSectionName( String sectionId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String sectionid = null;
	    String sectionurl = null;
	    String sectionname = null;
	    query0 = "Select * from Section where Id="+sectionId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Section obj = new Section();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				sectionid = rs.getString("Id");
			    sectionurl = rs.getString("SectionUrl");
			    sectionname = rs.getString("SectionName");
			    System.out.println(sectionurl);
	            
	 
	             obj.setSectionUrl(sectionurl);
	    		 obj.setId(sectionid);
	    	     obj.setSectionName(sectionname);
	    		 section.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}   
	         
	        
	    return obj;
 }

   public static Site getSiteName( String siteId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String siteid = null;
	    String siteurl = null;
	    String sitename = null;
	    query0 = "Select * from Site where Id="+siteId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	         
	        
	    return obj;
 }

   
   public static Site getSiteDetails( String sitename ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String siteid = null;
	    String siteurl = null;
//	    String sitename = null;
	    query0 = "Select * from Site where SiteName='"+sitename+"'";
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	         
	        
	    return obj;
 }

   
   
   
   
   
   
   
   
   
   
   public static List<Site> getSiteData( String userId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Site> site = new ArrayList<Site>();
	    String siteid = null;
	    String siteurl = null;
	    String sitename = null;
	    query0 = "Select * from Site where UserId="+userId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		 site.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}   
	         
	        
	    return site;
 }

   public static DashboardTemplate getDashboardTemplate( String Id ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware1";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector1 connector1 = new DBConnector1();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	    String query2 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Site> site = new ArrayList<Site>();
	    String id = null;
	    String siteid = null;
	    String siteurl = null;
	    String sitename = null;
	    String dashboardtype= null;
	    String timespan = null;
	    String endpoint = null;
	    String cardTitle =null;
	    String dropdown=null;
	    List<TemplateMap> tempmap = new ArrayList<TemplateMap>();
	    List<TimeSpanMap> timespanmap = new ArrayList<TimeSpanMap>();
	    List<DropdownMap> dropdownmap = new ArrayList<DropdownMap>();
	    DashboardTemplate template = new DashboardTemplate();
	    ResultSet rs = null;
	    ResultSet rs1 = null;
	    ResultSet rs2 = null;
	    Statement st = null;
	    Statement st1 = null;
	    Statement st2 = null;
	   try{
	    
	    query0 = "Select * from TemplateMap where siteId="+Id;
	    
	    
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	   
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
				 TemplateMap obj = new TemplateMap();
				siteid = rs.getString("SiteId");
			    endpoint = rs.getString("endPoint");
			    id = rs.getString("Id");
			    cardTitle = rs.getString("CardTitle");
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setEndpoint(endpoint);
	    	     obj.setId(id);
	    		 obj.setCardTitle(cardTitle);
	    	     tempmap.add(obj);
	    	
			}    		 
		 
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }

		 
		 
		 query1 = "Select * from TimeSpan where SiteId="+Id;
		    
		 
		 
		 
		 
			try {
				st1 = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      
		      // execute the query, and get a java resultset
		    
		     Site obj1 = new Site();
		     
		     try {
				rs1 = st1.executeQuery(query1);
			    
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 try {
				while(rs1.next()){
					TimeSpanMap obj = new TimeSpanMap();
					siteid = rs1.getString("SiteId");
					id = rs1.getString("Id");
				    
				    dashboardtype = rs1.getString("DashBoardType");
				    timespan = rs1.getString("Timespan");
		            
		 
		             obj.setSiteId(siteid);
		    		 obj.setId(id);
		    	     obj.setDashboardType(dashboardtype);
		    		 obj.setTimeSpan(timespan);
		    		 timespanmap.add(obj);
		    	
				}    		 
			 
			 }  
		      catch(Exception e){
		    	  
		    	  
		      }
		 
		 
		 
			 query2 = "Select * from DropdownMap where siteId="+Id;
			    
			   
				try {
					st2= con.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      
			      // execute the query, and get a java resultset
			    
			     Site obj2 = new Site();
			     
			     try {
					rs2 = st2.executeQuery(query2);
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 try {
					while(rs2.next()){
			    	    DropdownMap obj = new DropdownMap(); 
						id = rs2.getString("Id");
					    siteid = rs2.getString("siteId");
					   
					    dropdown = rs2.getString("Dropdown");
					    endpoint = rs2.getString("endpoint");
			            
			            obj.setDropdown(dropdown);
			    	    obj.setEndpoint(endpoint);
			    	    obj.setId(id);
			    	    obj.setSiteId(siteid);
					    dropdownmap.add(obj);
					 
					}    		 
				 
				 }  
			      catch(Exception e){
			    	  
			    	  
			      }
		 
		 
		 
		     template.setDropdownmap(dropdownmap);
		     template.setTempmap(tempmap);
		     template.setTimespanmap(timespanmap);
		 
	   }
	   catch(Exception e){
		   
		   
	   }
		 
		 
		 finally{
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				
				 DBUtil.close(rs1);
					DBUtil.close(st1);
					 DBUtil.close(rs2);
						DBUtil.close(st2);
						DBUtil.close(con);	
		 }
			   
	        
	        
	    return template;
 }
   
   
   


}