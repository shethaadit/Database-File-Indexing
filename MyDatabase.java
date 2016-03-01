import java.io.*;
import java.util.*;

//IMPORTING EXTERNAL LIBRARY FOR CSV READER
import com.opencsv.CSVReader;

//MAIN CLASS
public class MyDatabase
{
	//LAST FOUR BOOLEAN ATTRIBUTES AND ASSIGNING THEM AS PER POWER OF 2
	public static byte fda_appr = 1;
	
	public static byte gov_f  = 2;
	
	public static byte controlled_study = 4;
	
	public static byte double_blind  = 8;    

	//MAIN FUNCTION
	public static void main(String[] args) throws Exception
	{
		System.out.println("************************************************************");
		System.out.println();
		System.out.println("Please select choice : ");
		System.out.println("1. Parse into Binary and generate index files");
		System.out.println("2. Query on field");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println("************************************************************");
		
		Scanner s = new Scanner(System.in);
		int selection = s.nextInt();
		
		//SKIPPING FIRST HEADER LINE
		s.nextLine();
		
		while(selection!=3)
		{
			
			if(selection == 1)
			{
				//System.out.println("Please enter filename: ");
				//String fpath=s.next();
				
				//CSV FILE
				parse("PHARMA_TRIALS_1000B.csv");
				selection=0;
				
			}
			else if(selection == 2)
			{
				System.out.println("Please select query field");
				System.out.println("1:ID, 2:Company, 3:Drug ID, 4:Trials, 5:Patients, 6:Dosage, 7:Reading, 8:Double_Blind, 9:Controlled_Study, 10:Government_Funded, 11:FDA_Approved");
				

				int field = s.nextInt();

				//SKIPPING FIRST ROW
				s.nextLine();
				
				//ATTRIBUTES WITH STRING DATA
				if((field>3 && field<=7) || field==1  )
				{
					System.out.println("Please select appropriate sign: LessThan(<), GreaterThan(>), Equals(=), LessThanEqual(<=), GreaterThanEqual(>=), NotEqual(!=)");
					String op = s.next();
					
					op=op.trim();
					s.nextLine();
					System.out.println("Please chose appropriate value: ");
					String queryVal = s.next();
					s.nextLine();

					//QUERY ON ID ATTRIBUTE
					if(field==1)
					{
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							int val_query = Integer.parseInt(queryVal);
							if(op.equals("="))
							{
								ID_query(val_query);
							}
							else if(op.equals(">"))
							{

								for(int i=val_query+1;i<=1000;i++)
								{
									ID_query(i);
								}

							}

							else if(op.equals(">="))
							{

								for(int i=val_query;i<=1000;i++)
								{
									ID_query(i);
								}

							}

							else if(op.equals("<"))
							{

								for(int i=1;i<val_query;i++)
								{
									ID_query(i);
								}

							}

							else if(op.equals("<="))
							{

								for(int i=1;i<=val_query;i++)
								{
									ID_query(i);
								}

							}

							else if(op.equals("!="))
							{

								for(int i=1;i<=1000;i++)
								{
									if(i == val_query)
									{
										continue;
									}
									else
									{
										ID_query(i);
									}
								}

							}

							System.out.println("******************************************************************************");

						}
						else if(field==4)
						{

							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							int val_query = Integer.parseInt(queryVal);
							if(op.equals("="))
							{
								Trials_query(val_query);
							}
							else if(op.equals("<"))
							{

								for(int i=10;i<val_query;i++)
								{
									Trials_query(i);
								}

							}
							else if(op.equals(">"))
							{

								for(int i=val_query+1;i<=100;i++)
								{
									Trials_query(i);
								}

							}
							else if(op.equals("<="))
							{
								for(int i=10;i<=val_query;i++)
								{
									Trials_query(i);
								}
							}
							
							else if(op.equals(">="))
							{

								for(int i=val_query;i<=100;i++)
								{
									Trials_query(i);
								}

							}

							else if(op.equals("!="))
							{

								for(int i=1;i<=1000;i++)
								{
									if(i == val_query)
									{
										continue;
									}
									else
									{
										ID_query(i);
									}
								}

							}

							System.out.println("******************************************************************");

						}
						

					else if(field==5)
					{
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							int val_query = Integer.parseInt(queryVal);
							if(op.equals("="))
							{
								patients_query(val_query);
							}

							else if(op.equals(">"))
							{

								for(int i=val_query+1;i<=2500;i++)
								{
									patients_query(i);
								}

							}

							else if(op.equals(">="))
							{

								for(int i=val_query;i<=2500;i++)
								{
									patients_query(i);
								}

							}

							else if(op.equals("<"))
							{

								for(int i=1000;i<val_query;i++)
								{
									patients_query(i);
								}

							}

							else if(op.equals("<="))
							{

								for(int i=1000;i<=val_query;i++)
								{
									patients_query(i);
								}

							}

							else if(op.equals("!="))
							{

								for(int i=1;i<=1000;i++)
								{
									if(i == val_query)
									{
										continue;
									}
									else
									{
										ID_query(i);
									}
								}
							}

							System.out.println("**************************************************************************************************");

						}
						
					else if(field==6)
					{
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							int val_query = Integer.parseInt(queryVal);
							if(op.equals("="))
							{
								dosage_query(val_query);
							}

							else if(op.equals(">"))
							{

								for(int i=val_query+1;i<=500;i++)
								{
									dosage_query(i);
								}

							}

							else if(op.equals(">="))
							{

								for(int i=val_query;i<=500;i++)
								{
									dosage_query(i);
								}

							}

							else if(op.equals("<"))
							{

								for(int i=6;i<val_query;i++)
								{
									dosage_query(i);
								}

							}

							else if(op.equals("<="))
							{

								for(int i=6;i<=val_query;i++)
								{
									dosage_query(i);
								}

							}

							else if(op.equals("!="))
							{

								for(int i=1;i<=1000;i++)
								{
									if(i == val_query)
									{
										continue;
									}
									else
									{
										ID_query(i);
									}
								}							}

							System.out.println("****************************************************************");

						}
						
					else if(field==7)
					{
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							float queryValue = Float.parseFloat(queryVal);

							reading_query(queryValue,op);

							System.out.println("*******************************************************************************");

						}
						
				}
				else if(field==2)
				{

					System.out.println("Enter Company Name: ");
					String companyName=null;

					companyName=s.nextLine();

						if(companyName!=null)
						{
							
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							companyname_query(companyName);
							System.out.println("******************************************************************************************");
						}
				}
				else if(field==3)
				{

					System.out.println("Enter Drug Name: ");
					String drugName=null;

					drugName=s.nextLine();

						if(drugName!=null)
						{
							
							System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
							drugname_query(drugName);
							System.out.println("***********************************************************************************");
						}
					}
				
				

				else  
				{

					System.out.println("Enter True/False: ");
					String tf=s.next();
					s.nextLine();

					if(field==8)
					{

							if(tf!=null)
							{
								
								System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
								doubleblind_query(tf);
								System.out.println("************************************************************************************");
							}
						
					}



					else if(field==9)
					{

							if(tf!=null)
							{
								
								System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
								controlledstudy_query(tf);
								System.out.println("************************************************************************************");
							}
						
					}
					else if(field==10)
					{

							if(tf!=null)
							{
								
								System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double_Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
								//System.out.println(tf);
								govfunded_query(tf);
								System.out.println("***************************************************************************************");
							}
					}



					else if(field==11)
					{

							if(tf!=null)
							{
								
								System.out.println("ID   Drug-Id Trials  Patients  Dosage  Reading  Double-Blind  Controlled_Study  Govt_Funded  FDA_Approved  Company");
								fdaApp_query(tf);
								System.out.println("***********************************************************************");
							}
					}


				}
				
			}

		}
		System.out.println();
		System.out.println("-----------Exited-----------");

	}

	public static void parse(String filePath)
	{
		String parsing_file = filePath;

		int count=0;
		Map<Integer,Integer> idMap = new TreeMap<Integer,Integer>();
		DataOutputStream idInd=null;
		Map<String,String> drugMap = new TreeMap<String,String>();		
		DataOutputStream drugInd=null;
		Map<Integer,String> trialsMap = new TreeMap<Integer,String>();
		DataOutputStream trialsInd=null;
		Map<String,String> companyMap = new TreeMap<String,String>();
		DataOutputStream companyInd=null;
		Map<Integer,String> patientsMap = new TreeMap<Integer,String>();
		DataOutputStream patientsInd=null;
		Map<Integer,String> dosageMap = new TreeMap<Integer,String>();
		DataOutputStream dosageInd=null;
		Map<Float,String> readingMap = new TreeMap<Float,String>();
		DataOutputStream readingInd=null;
		Map<String,String> doubleBlindMap = new TreeMap<String,String>();
		DataOutputStream doubleBlindInd=null;
		Map<String,String> csMap = new TreeMap<String,String>();
		DataOutputStream csInd=null;
		Map<String,String> gfMap = new TreeMap<String,String>();
		DataOutputStream gfInd=null;
		Map<String,String> fdaMap = new TreeMap<String,String>();
		DataOutputStream fdaInd=null;

		int size=0;
		StringBuffer strBuff = new StringBuffer();

		RandomAccessFile file = null;
		CSVReader reader = null;
		try
		{
			file = new RandomAccessFile("data.db", "rw");
			idInd = new DataOutputStream(new FileOutputStream("id.ndx"));
			companyInd = new DataOutputStream(new FileOutputStream("company.ndx"));
			drugInd = new DataOutputStream(new FileOutputStream("drug.ndx"));
			trialsInd = new DataOutputStream(new FileOutputStream("trials.ndx"));
			patientsInd = new DataOutputStream(new FileOutputStream("patients.ndx"));
			dosageInd = new DataOutputStream(new FileOutputStream("dosage.ndx"));
			readingInd = new DataOutputStream(new FileOutputStream("reading.ndx"));
			doubleBlindInd = new DataOutputStream(new FileOutputStream("doubleBlind.ndx"));
			csInd = new DataOutputStream(new FileOutputStream("controlledStudy.ndx"));
			gfInd = new DataOutputStream(new FileOutputStream("govtFunded.ndx"));
			fdaInd = new DataOutputStream(new FileOutputStream("fdaApproved.ndx"));

			reader = new CSVReader(new FileReader(parsing_file));

			String [] t;

			while ((t = reader.readNext()) != null)
			{
				if(count==0)
				{
					++count;
					continue;
				}

				int id=Integer.parseInt(t[0]);
				if(idMap.get(id)==null)
					idMap.put(id, size);

				if(companyMap.get(t[1])==null)
				{
					companyMap.put(t[1], idMap.get(id)+"");
				}
				else
				{
					companyMap.put(t[1],companyMap.get(t[1])+"\t"+idMap.get(id)+"");
				}
				file.writeInt(id);

				size+=4;

				int lenCompany = t[1].length();
				file.writeByte(lenCompany);

				size+=1;

				char[] companyChars = t[1].toCharArray();

				for (int j = 0; j < companyChars.length; j++)
				{	      	            	  


					file.writeByte(companyChars[j]);  
					strBuff.append(String.format("%8s", Integer.toBinaryString((int) companyChars[j])).replace(' ', '0'));
				}

				size+=lenCompany;

				char[] charsDrug = t[2].toCharArray();

				for (int j = 0; j < charsDrug.length; j++)
				{	  

					file.writeByte(charsDrug[j]);  
				}


				if(drugMap.get(t[2])==null)
				{
					drugMap.put(t[2], idMap.get(id)+"");
				}
				else
				{
					drugMap.put(t[2],drugMap.get(t[2])+"\t"+idMap.get(id)+"");
				}

				size+=6;

				int trials = Integer.parseInt(t[3]);
				file.writeShort(trials);
				size+=2;

				if(trialsMap.get(trials)==null)
				{
					trialsMap.put(trials, idMap.get(id)+"");
				}
				else
				{
					trialsMap.put(trials,trialsMap.get(trials)+"\t"+idMap.get(id)+"");
				}



				int patients = Integer.parseInt(t[4]);
				file.writeShort(patients);
				size+=2;

				if(patientsMap.get(patients)==null)
				{
					patientsMap.put(patients, idMap.get(id)+"");
				}
				else
				{
					patientsMap.put(patients,patientsMap.get(patients)+"\t"+idMap.get(id)+"");
				}



				int dosage = Integer.parseInt(t[5]);
				file.writeShort(dosage);
				size+=2;


				if(dosageMap.get(dosage)==null)
				{
					dosageMap.put(dosage, idMap.get(id)+"");
				}
				else
					{
					dosageMap.put(dosage,dosageMap.get(dosage)+"\t"+idMap.get(id)+"");
					}

				String reading = t[6];


				float f = Float.valueOf(reading).floatValue();
				file.writeFloat(f);


				if(readingMap.get(f)==null)
				{
					readingMap.put(f, idMap.get(id)+"");
				}
				else
				{
					readingMap.put(f,readingMap.get(f)+"\t"+idMap.get(id)+"");
				}

				size+=4;

				byte byte_boolean = 0x00; 



				if("true".equalsIgnoreCase(t[7]))
				{
					double_blind=8;
				}
				else
				{
					double_blind=0;
				}



				if(doubleBlindMap.get(t[7])==null)
				{
					doubleBlindMap.put(t[7], idMap.get(id)+"");
				}
				else
					{
					doubleBlindMap.put(t[7],doubleBlindMap.get(t[7])+"\t"+idMap.get(id)+"");
					}


				if("true".equalsIgnoreCase(t[8]))
				{
					controlled_study=4;
				}
				else
				{
					controlled_study=0;
				}

				if(csMap.get(t[8])==null)
				{
					csMap.put(t[8], idMap.get(id)+"");
				}
				else
				{
					csMap.put(t[8],csMap.get(t[8])+"\t"+idMap.get(id)+"");
				}



				if("true".equalsIgnoreCase(t[9]))
				{
					gov_f=2;
				}
				else
				{
					gov_f=0;
				}

				if(gfMap.get(t[9])==null)
				{
					gfMap.put(t[9], idMap.get(id)+"");
				}
				else
				{
					gfMap.put(t[9],gfMap.get(t[9])+"\t"+idMap.get(id)+"");
				}



				if("true".equalsIgnoreCase(t[10]))
				{
					fda_appr=1;
				}
				else
				{
					fda_appr=0;
				}

				if(fdaMap.get(t[10])==null)
				{
					fdaMap.put(t[10], idMap.get(id)+"");
				}
				else
				{
					fdaMap.put(t[10],fdaMap.get(t[10])+"\t"+idMap.get(id)+"");
				}


				byte_boolean = (byte)(byte_boolean|double_blind);
				
				byte_boolean = (byte)(byte_boolean|controlled_study);
				
				byte_boolean = (byte)(byte_boolean|gov_f);
				
				byte_boolean = (byte)(byte_boolean|fda_appr);
				file.writeByte(byte_boolean);
				size+=1;
				++count;
			}

			Iterator i = idMap.entrySet().iterator();
			StringBuffer buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t " + p.getValue());
				buffer.append(p.getKey()+","+p.getValue());
				buffer.append("\n");
			}

			idInd.writeBytes(buffer.toString());

			i = companyMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			companyInd.writeBytes(buffer.toString());


			i = drugMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			drugInd.writeBytes(buffer.toString());
			i = trialsMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			trialsInd.writeBytes(buffer.toString());
			i = patientsMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			patientsInd.writeBytes(buffer.toString());
			i = dosageMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			dosageInd.writeBytes(buffer.toString());
			i = readingMap.entrySet().iterator();
			buffer = new StringBuffer();
			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			readingInd.writeBytes(buffer.toString());
			i = doubleBlindMap.entrySet().iterator();
			buffer = new StringBuffer();
			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			doubleBlindInd.writeBytes(buffer.toString());
			i = csMap.entrySet().iterator();
			buffer = new StringBuffer();
			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");
			}

			csInd.writeBytes(buffer.toString());
			i = gfMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");


			}
			gfInd.writeBytes(buffer.toString());
			i = fdaMap.entrySet().iterator();
			buffer = new StringBuffer();

			while (i.hasNext()) 
			{
				Map.Entry p = (Map.Entry)i.next();
				System.out.println(p.getKey() + ":\t" + p.getValue());
				buffer.append(p.getKey()+":\t"+p.getValue());
				buffer.append("\n");


			}

			fdaInd.writeBytes(buffer.toString());
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			try 
			{
				companyInd.close();
			} 
			catch (IOException e1) 
			{
				
				e1.printStackTrace();
			}

			
		}
		finally
		{
			try 
			{

				reader.close();
				idInd.close();
				companyInd.close();
				drugInd.close();
				trialsInd.close();
				patientsInd.close();
				dosageInd.close();
				readingInd.close();
				doubleBlindInd.close();
				csInd.close();
				gfInd.close();
				fdaInd.close();

			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static String ID_query(int id) throws IOException
	{

		StringBuffer ans = new StringBuffer();

		String filePath="id.ndx";
		RandomAccessFile file = null;
		FileInputStream f=null;
		BufferedReader b =null;

		try 
		{

			file = new RandomAccessFile("data.db", "r");

			f= new FileInputStream(filePath);
			b= new BufferedReader(new InputStreamReader(f));

			for(int i = 0; i < id-1; ++i)
				b.readLine();

			String line = b.readLine();

			String[] ar = line.split(",");

			int temp_bytes = Integer.parseInt(ar[1]);

			file.seek(temp_bytes);
			int a=file.readInt();
			int size = file.read();
			System.out.print(a);
			System.out.print("  ");

			byte[] company_names = new byte[size];
			for(int i=0;i<size;i++)
				company_names[i]=(byte) file.read();



			byte[] drug_Id = new byte[6];
			for(int i=0;i<6;i++)
				drug_Id[i]=(byte) file.read();

			String drug_names = new String(drug_Id);

			System.out.print(drug_names);
			System.out.print("   ");

			int trials = file.readShort();

			int patients = file.readShort();

			int dosage = file.readShort();

			float reading = file.readFloat();
			System.out.print(trials);
			System.out.print("   |   ");
			System.out.print(patients);
			System.out.print("   |   ");
			System.out.print(dosage);
			System.out.print("   |   ");
			System.out.print(reading);
			System.out.print("   |   ");
			byte c_byte = file.readByte();



			if((c_byte & double_blind)==0)
			{
				System.out.print("FALSE");
				System.out.print("    |    ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("    |    ");

			}

			if((c_byte & controlled_study)==0)
			{
				System.out.print("FALSE");
				System.out.print("      |       ");

			}
			else
			{
				System.out.print("TRUE");
				System.out.print("       |       ");

			}

			if((c_byte & gov_f)==0)
			{
				System.out.print("FALSE");
				System.out.print("   |    ");
			}
			else
			{
				System.out.print("TRUE");
				System.out.print("    |    ");
			}

			if((c_byte & fda_appr)==0)
			{

				System.out.print("FALSE");
				System.out.print("     ");
			}

			else
			{
				System.out.print("TRUE");
				System.out.print("   |   ");
			}


			String companyName = new String(company_names);
			System.out.print(companyName);


			System.out.println("");
		} 
		finally
		{

			try{
				file.close();
				b.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return ans.toString();
	}




	public static void companyname_query(String company_names) throws Exception
	{
		RandomAccessFile file = null;
		FileInputStream f= null;
		BufferedReader b =null;
		company_names=company_names.trim();
		try
		{
			String filePath="company.ndx";
			file = new RandomAccessFile("data.db", "r");
			f= new FileInputStream(filePath);
			b = new BufferedReader(new InputStreamReader(f));

			String line_req ="";
			String line_n="";

			while((line_n=b.readLine())!=null)
			{

				String tenp_line_n[] = line_n.split(":\t");
				if(company_names.equalsIgnoreCase(tenp_line_n[0]))
				{
					line_req=line_n;
					break;
				}
			}

			String[] data = line_req.split(":\t");
			String[] id = data[1].split("\t");
			displayData(id);


		}

		finally
		{
			file.close();
			f.close();
			b.close();
		}

	}


	public static void drugname_query(String drug_ID) throws Exception
	{
		FileInputStream f= null;
		BufferedReader b =null;
		drug_ID=drug_ID.trim();
		try
		{
			String filePath="drug.ndx";

			f= new FileInputStream(filePath);
			b = new BufferedReader(new InputStreamReader(f));

			String line_req ="";
			String line_n="";

			while((line_n=b.readLine())!=null)
			{

				
				String temp_line[] = line_n.split(":\t");
				if(drug_ID.equalsIgnoreCase(temp_line[0]))
				{
					line_req=line_n;
					break;
				}
			}

			String[] data = line_req.split(":\t");

			String[] id = data[1].split("\t");

			displayData(id);
		}

		finally
		{

			f.close();
			b.close();
		}

	}



	public static void Trials_query(int trialNum) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader buffer_r =null;
		

		try
		{
			String filePath="trials.ndx";

			fs= new FileInputStream(filePath);
			buffer_r = new BufferedReader(new InputStreamReader(fs));

			String line ="";
			String nextLine="";

			while((nextLine=buffer_r.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(trialNum == Integer.parseInt(nextLineArr[0]))
				{
					line=nextLine;
					break;
				}
			}

			String[] data = line.split(":\t");

			String[] id = data[1].split("\t");

			displayData(id);
		}

		finally
		{

			
			buffer_r.close();
		}

	}

	public static void patients_query(int patientsNum) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;
		try
		{
			String filePath="patients.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(patientsNum == Integer.parseInt(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");
				displayData(id);

			}



		}

		finally
		{
			fs.close();
			br.close();
		}

	}

	public static void dosage_query(int dosageNum) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="dosage.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(dosageNum == Integer.parseInt(nextLineArr[0]))
				{
					reqdLine=nextLine;
					break;
				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");

				displayData(id);
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}

	public static void reading_query(float readingNum, String operator) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;
		String[] id = null;
		boolean flag = false;

		try
		{
			String filePath="reading.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(operator.equals("="))
				{
					if(readingNum == Float.parseFloat(nextLineArr[0]))
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						flag=true;						
					}


				}

				else if(operator.equals(">"))
				{

					if(Float.parseFloat(nextLineArr[0])>readingNum)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						
						
					}

				}

				else if(operator.equals(">="))
				{

					if(Float.parseFloat(nextLineArr[0])>=readingNum)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						
					}


				}

				else if(operator.equals("<"))
				{

					if(Float.parseFloat(nextLineArr[0])<readingNum)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						
					}


				}

				else if(operator.equals("<="))
				{

					if(Float.parseFloat(nextLineArr[0])<=readingNum)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						
					}


				}

				else if(operator.equals("!="))
				{

					if(Float.parseFloat(nextLineArr[0])!=readingNum)
					{
						reqdLine=nextLine;

					}


					if(reqdLine!=null && !("".equals(reqdLine)))
					{
						String[] data = reqdLine.split(":\t");

						id = data[1].split("\t");
						if(id!=null && id.length>0)
							displayData(id);
						
						id=null;
						reqdLine=null;
						
					}
		}

				
				if(flag)
					break;


			}

		}

		finally
		{

			fs.close();
			br.close();
		}

	}
	public static void doubleblind_query(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="doubleBlind.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;

				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");

				displayData(id);
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}

	public static void controlledstudy_query(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;
		

		try
		{
			String filePath="controlledStudy.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;

				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");

				displayData(id);

			}



		}

		finally
		{
			fs.close();
			br.close();
		}

	}
	public static void govfunded_query(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;


		try
		{
			String filePath="govtFunded.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;

				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");
				displayData(id);
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}



	public static void fdaApp_query(String tf) throws Exception
	{

		FileInputStream fs= null;
		BufferedReader br =null;

		try
		{
			String filePath="fdaApproved.ndx";

			fs= new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fs));

			String reqdLine ="";
			String nextLine="";

			while((nextLine=br.readLine())!=null)
			{

				String nextLineArr[] = nextLine.split(":\t");
				if(tf.equalsIgnoreCase(nextLineArr[0]))
				{
					reqdLine=nextLine;

				}
			}

			if(reqdLine!=null && !("".equals(reqdLine)))
			{
				String[] data = reqdLine.split(":\t");

				String[] id = data[1].split("\t");

				displayData(id);
			}



		}

		finally
		{

			fs.close();
			br.close();
		}

	}
	public static void displayData(String[] arr) throws Exception
	{

		RandomAccessFile file = null;

		try{
			file = new RandomAccessFile("data.db", "r");
			for (int k=0;k<arr.length;k++)
			{
				int bytesToSkip = Integer.parseInt(arr[k]);

				file.seek(bytesToSkip);
				int a=file.readInt();
				int size = file.read();
				System.out.print(a);
				System.out.print("  ");

				byte[] companyNames = new byte[size];
				for(int i=0;i<size;i++)
					companyNames[i]=(byte) file.read();



				byte[] drugId = new byte[6];
				for(int i=0;i<6;i++)
					drugId[i]=(byte) file.read();

				String drugName = new String(drugId);

				System.out.print(drugName);
				System.out.print("   ");

				int trials = file.readShort();

				int patients = file.readShort();

				int dosage = file.readShort();

				float reading = file.readFloat();
				System.out.print(trials);
				System.out.print("      ");
				System.out.print(patients);
				System.out.print("      ");
				System.out.print(dosage);
				System.out.print("      ");
				System.out.print(reading);
				System.out.print("      ");
				byte commonByte = file.readByte();



				if((commonByte & double_blind)==0)
				{
					System.out.print("FALSE");
					System.out.print("        ");
				}
				else
				{
					System.out.print("TRUE");
					System.out.print("         ");

				}

				if((commonByte & controlled_study)==0)
				{
					System.out.print("FALSE");
					System.out.print("             ");

				}
				else
				{
					System.out.print("TRUE");
					System.out.print("              ");

				}

				if((commonByte & gov_f)==0)
				{
					System.out.print("FALSE");
					System.out.print("       ");
				}
				else
				{
					System.out.print("TRUE");
					System.out.print("        ");
				}

				if((commonByte & fda_appr)==0){

					System.out.print("FALSE");
					System.out.print("     ");
				}

				else{
					System.out.print("TRUE");
					System.out.print("      ");
				}


				String compName = new String(companyNames);
				System.out.print(compName);


				System.out.println("");
			}
		}

		finally
		{
			file.close();
		}
	}

}
