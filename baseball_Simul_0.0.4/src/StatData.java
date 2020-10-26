import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatData{
	
	int order;
	String name;
	String team;
	String position;
	int number;
	int win;
	float whip; 
	float era; 
	float ops;
	int strike; 
	int ball;
	int hit, homerun, fourball;
	float hitrate;
	
	
	final static ArrayList<Pitcher> pitcherlistA = new ArrayList<Pitcher>();
	final static ArrayList<Batter> batterlistA = new ArrayList<Batter>();
	final static ArrayList<Pitcher> pitcherlistB = new ArrayList<Pitcher>();
	final static ArrayList<Batter> batterlistB = new ArrayList<Batter>();
	
	public void getStat() {
		
		
		String path = "C:\\Users\\boy16\\git\\baseballSimul\\baseball_Simul_0.0.4\\src\\playerdata.xlsx";
		
		try {
			File file = new File(path);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook hworkbook = new XSSFWorkbook(inputStream);
			
			XSSFSheet curSheet;
			XSSFCell curCell;
			XSSFRow curRow;
			
			int sheetNumber = hworkbook.getNumberOfSheets();
			
			while(sheetNumber!=0) {
				sheetNumber--;
				
				curSheet = hworkbook.getSheetAt(sheetNumber);
				int row = curSheet.getPhysicalNumberOfRows();
				
				
				for(int rowIndex = 0; rowIndex<row;rowIndex++) {
					
					curRow = curSheet.getRow(rowIndex);
					
					
					if(String.valueOf(curRow.getCell(0)).equals("A")) {
						if(String.valueOf(curRow.getCell(1)).equals("P")) {
							
							// for(int cellIndex = 0;cellIndex<curRow.getPhysicalNumberOfCells();cellIndex++) {	}				
								team = String.valueOf(curRow.getCell(0));
								position = String.valueOf(curRow.getCell(1));
								order = (Double.valueOf(String.valueOf(curRow.getCell(2)))).intValue();
								name = String.valueOf(curRow.getCell(3));
								number = (Double.valueOf(String.valueOf(curRow.getCell(4)))).intValue();
								win = (Double.valueOf(String.valueOf(curRow.getCell(5)))).intValue();
								era = Float.valueOf(String.valueOf(curRow.getCell(6)));
								whip = Float.valueOf(String.valueOf(curRow.getCell(7)));
								strike = (Double.valueOf(String.valueOf(curRow.getCell(8)))).intValue();
								ball = (Double.valueOf(String.valueOf(curRow.getCell(9)))).intValue();
								
								pitcherlistA.add(new Pitcher(team,position,order,name,number,win,era,whip,strike,ball));	
							
								
						}else {
								team = String.valueOf(curRow.getCell(0));
								position = String.valueOf(curRow.getCell(1));
								order = (Double.valueOf(String.valueOf(curRow.getCell(2)))).intValue();
								name = String.valueOf(curRow.getCell(3));
								number = (Double.valueOf(String.valueOf(curRow.getCell(4)))).intValue();
								hit = (Double.valueOf(String.valueOf(curRow.getCell(5)))).intValue();
								ops = Float.valueOf(String.valueOf(curRow.getCell(6)));
								homerun = (Double.valueOf(String.valueOf(curRow.getCell(7)))).intValue();
								fourball = (Double.valueOf(String.valueOf(curRow.getCell(8)))).intValue();
								hitrate = Float.valueOf(String.valueOf(curRow.getCell(9)));
								
								batterlistA.add(new Batter(team,position,order,name,number,hit,ops,homerun,fourball,hitrate));
								
						}
						
					}else {
								if(String.valueOf(curRow.getCell(1)).equals("P")) {
							
							// for(int cellIndex = 0;cellIndex<curRow.getPhysicalNumberOfCells();cellIndex++) {	}				
								team = String.valueOf(curRow.getCell(0));
								position = String.valueOf(curRow.getCell(1));
								order = (Double.valueOf(String.valueOf(curRow.getCell(2)))).intValue();
								name = String.valueOf(curRow.getCell(3));
								number = (Double.valueOf(String.valueOf(curRow.getCell(4)))).intValue();
								win = (Double.valueOf(String.valueOf(curRow.getCell(5)))).intValue();
								era = Float.valueOf(String.valueOf(curRow.getCell(6)));
								whip = Float.valueOf(String.valueOf(curRow.getCell(7)));
								strike = (Double.valueOf(String.valueOf(curRow.getCell(8)))).intValue();
								ball = (Double.valueOf(String.valueOf(curRow.getCell(9)))).intValue();
								
								pitcherlistB.add(new Pitcher(team,position,order,name,number,win,era,whip,strike,ball));	
								
						}else {
								team = String.valueOf(curRow.getCell(0));
								position = String.valueOf(curRow.getCell(1));
								order = (Double.valueOf(String.valueOf(curRow.getCell(2)))).intValue();
								name = String.valueOf(curRow.getCell(3));
								number = (Double.valueOf(String.valueOf(curRow.getCell(4)))).intValue();
								hit = (Double.valueOf(String.valueOf(curRow.getCell(5)))).intValue();
								ops = Float.valueOf(String.valueOf(curRow.getCell(6)));
								homerun = (Double.valueOf(String.valueOf(curRow.getCell(7)))).intValue();
								fourball = (Double.valueOf(String.valueOf(curRow.getCell(8)))).intValue();
								hitrate = Float.valueOf(String.valueOf(curRow.getCell(9)));
								
								batterlistB.add(new Batter(team,position,order,name,number,hit,ops,homerun,fourball,hitrate));
						}
					
					
					}
					
					
				}
				
				}
				
			}catch(FileNotFoundException e) {
				System.out.println("파일 못 찾음");
				e.printStackTrace();
			}catch(IOException e) {
				System.out.println("파일 불러오기 오류");
				e.printStackTrace();
			}
			
	}
	
}