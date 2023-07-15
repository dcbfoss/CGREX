
// class name : SeqTypeConversion.class
//package CGRexpack;
import java.io.*;
import java.util.*;

public class SeqTypeConversion
{
String seq_string;
    public SeqTypeConversion()
    {
    }
    public void dnatorna(String s)
    {
    		/*if(s == null)
    		//return null;
    		else if(s.equals("") || delims == null || delims.length() == 0)
    		//return new String[]{ s };
    	    String[] s1;
    	  	Vector v = new Vector();
    		int pos = 0;
    		int newpos = s.indexOf(delims, pos);;
    		while(newpos != -1)
    		{
    			v.addElement(s.substring(pos, newpos));
    			pos = newpos + delims.length();
    			newpos = s.indexOf(delims, pos);
    		}
    		v.addElement(s.substring(pos));
    		
    		s1 = new String[v.size()];
    		for(int i=0, cnt=s1.length; i<cnt; i++)
    		s1[i] = (String) v.elementAt(i);
    		//return s1;
    	*/
    	int slength = (s.length()/3);
  //  	System.out.println("test" + slength);
        String[]s2 = new String[slength];
        String[] aSeq = new String[slength];
                
        for(int x=0, y=0; x<s.length(); x=x+3, y++ )
        {	
       	   s2[y] = s.substring(x,x+3);
       	  
        }
        for (int i=0; i < s2.length ; i++)
        {
        	
        	if( s2[i].equals("ATT")  || s2[i].equals("ATC") || s2[i].equals("ATA"))
        	{
        		aSeq[i]="I";
        	}
        	else if( s2[i].equals("CTT") || s2[i].equals("CTC") || s2[i].equals("CTA")|| s2[i].equals("CTG") || s2[i].equals("TTA") || s2[i].equals("TTG"))
        	{
        		aSeq[i]="L";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("GTT") || s2[i].equals("GTC") || s2[i].equals("GTA")|| s2[i].equals("GTG"))
        	{
        		aSeq[i]="V";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("TTT") || s2[i].equals("TTC"))
        	{
        		aSeq[i]="F";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("ATG") )
        	{
        	//	System.out.println(s2[i]);
        		aSeq[i]="M";
        		
        	}
        	else if( s2[i].equals("TGT") || s2[i].equals("TGC"))
        	{
        		aSeq[i]="C";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("GCT") || s2[i].equals("GCC")|| s2[i].equals("GCA")|| s2[i].equals("GCG" ))
        	{
        		aSeq[i]="A";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GGT") || s2[i].equals("GGC") || s2[i].equals("GGA")|| s2[i].equals("GGG" ))
        	{
        		aSeq[i]="G";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CCT") || s2[i].equals("CCC") || s2[i].equals("CCA")|| s2[i].equals("CCG"))
        	{
        		aSeq[i]="P";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "ACT" )|| s2[i].equals("ACC")|| s2[i].equals("ACA")|| s2[i].equals("ACG"))
        	{
        		aSeq[i]="T";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TCT" )|| s2[i].equals("TCC")|| s2[i].equals("TCA" )|| s2[i].equals("TCG")|| s2[i].equals("AGT")|| s2[i].equals("AGC"))
        	{
        		aSeq[i]="S";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TAT" )|| s2[i].equals("TAC"))
        	{
        		aSeq[i]="Y";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TGG"))
        	{
        		aSeq[i]="W";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CAA" )|| s2[i].equals("CAG"))
        	{
        		aSeq[i]="Q";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "AAT" )|| s2[i].equals("AAC"))
        	{
        		aSeq[i]="N";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CAT" )|| s2[i].equals("CAC"))
        	{
        		aSeq[i]="H";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GAA" )|| s2[i].equals("GAG"))
        	{
        		aSeq[i]="E";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GAT" )|| s2[i].equals("GAC"))
        	{
        		aSeq[i]="D";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "AAA" )|| s2[i].equals("AAG"))
        	{
        		aSeq[i]="K";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CGT"  )|| s2[i].equals("CGC")|| s2[i].equals("CGA")|| s2[i].equals("CGG")|| s2[i].equals("AGA" )|| s2[i].equals("AGG"))
        	{
        		aSeq[i]="R";
        		//System.out.println(aSeq[i]);
        	}
        	else
        	{
        		aSeq[i]="A";
        	}
        //System.out.println(s2[i]); 
       // System.out.println("~~~~~~~~~~~");
      // 	System.out.println( aSeq[i]);	
        }
        String sa= new String();
        for(int i=0; i<aSeq.length; i++)
        {
        	sa= sa +aSeq[i];
        	
        }
        
      //  System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      //  System.out.println(sa);
        /*
        
        System.out.println("test now  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       	char ac[] = s.toCharArray();
        //String [] s2;
        String s1 = new String();
        for(int i = 0; i < s.length(); i++)
            if(ac[i] == 'T')
                ac[i] = 'U';

        for(int j = 0; j < s.length(); j++)
            s1 = s1 + ac[j];*/
        
        
        //System.out.println("SA -----"+sa);
       // System.out.println("abyte0.length ------"+abyte0.length);
        //System.out.println("abyte0 --------%s"+abyte0[0]);
        //System.out.println("abyte1 --------%s"+abyte0[1]);
        
        //System.out.println("abyte0 --------%s"+abyte0[1]);
        //System.out.println("abyte0 --------%s"+abyte0[2]+abyte0[3]+abyte0[4]+abyte0[5]);
        //System.out.println("abyte0.length ------"+abyte0.length);
        byte abyte0[] = sa.getBytes();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/dnatornaconv.txt"));
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }
        catch(Exception exception) { }
    }
    public void rnatodna(String s)
    {
        char ac[] = s.toCharArray();
        
        
        String s1 = new String();
        for(int i = 0; i < s.length(); i++)
            if(ac[i] == 'U')
                ac[i] = 'T';

        for(int j = 0; j < s.length(); j++)
            s1 = s1 + ac[j];

        byte abyte0[] = s1.getBytes();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/rnatodnaconv.txt"));
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }
        catch(Exception exception) { }
    }
    public void aminoacidtodna(String s)
    {
    	seq_string="";
    	
    	char[] str = s.toCharArray();
    	System.out.println("today...."+ str[1]);
    	for(int i=0; i< str.length ; i++)
    	{
    		System.out.println("today...."+ str[i]);
    		if(str[i] == 'I')
    		{
    			seq_string = seq_string+ "ATT";
    		}
    		else if(str[i] == 'L')
    		{
    			seq_string = seq_string+ "CTT";
    		}
    		else if(str[i] == 'V')
    		{
    			seq_string = seq_string+ "GTT";
    		}
    		else if(str[i] == 'F')
    		{
    			seq_string = seq_string+ "TTT";
    		}
    		else if(str[i] == 'M')
    		{
    			seq_string = seq_string+ "AGT";
    		}
    		else if(str[i] == 'C')
    		{
    			seq_string = seq_string+ "TGT";
    		}
    		else if(str[i] == 'A')
    		{
    			seq_string = seq_string+ "GCT";
    		}
    		else if(str[i] == 'G')
    		{
    			seq_string = seq_string+ "GGT";
    		}
    		else if(str[i] == 'P')
    		{
    			seq_string = seq_string+ "CCT";
    		}
    		else if(str[i] == 'T')
    		{
    			seq_string = seq_string+ "ACT";
    		}
    		else if(str[i] == 'S')
    		{
    			seq_string = seq_string+ "TCT";
    		}
    		else if(str[i] == 'Y')
    		{
    			seq_string = seq_string+ "TAT";
    		}
    		else if(str[i] == 'W')
    		{
    			seq_string = seq_string+ "TGG";
    		}
    		else if(str[i] == 'Q')
    		{
    			seq_string = seq_string+ "CAA";
    		}
    		else if(str[i] == 'N')
    		{
    			seq_string = seq_string+ "AAT";
    		}
    		else if(str[i] == 'H')
    		{
    			seq_string = seq_string+ "CAT";
    		}
    		else if(str[i] == 'E')
    		{
    			seq_string = seq_string+ "GAA";
    		}
    		else if(str[i] == 'D')
    		{
    			seq_string = seq_string+ "GAT";
    		}
    		else if(str[i] == 'K')
    		{
    			seq_string = seq_string+ "AAA";
    		}
    		else if(str[i] == 'R')
    		{
    			seq_string = seq_string+ "CGT";
    		}
    		else
    		{
    			seq_string = seq_string+"";
    		}
    		   		
    	}
    	System.out.println("STRING    is"+ seq_string);
    	 byte abyte0[] = seq_string.getBytes();
         try
         {
             FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/aminoacidtodnaconv.txt"));
             fileoutputstream.write(abyte0);
             fileoutputstream.close();
             }
         
         catch(Exception exception) { }
    }
    
    
    
    public void dnatoaminoacid(String s)
    {
        /*char ac[] = s.toCharArray();
        String as[] = new String[s.length() / 3];
        char ac1[] = new char[3];
        int i = -1;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
        {
            ac1[++i] = ac[k];
            if(i == 2)
            {
                i = -1;
                as[j] = String.valueOf(ac1);
                j++;
            }
        }
        j = 0;
        int l = 0;
        String s1 = new String();
        String as1[] = new String[s.length() / 3];
        while(j < (s.length() - 1) / 3 && (as[j] != "TAA" || as[j] != "TAG" || as[j] != "TGA"))
        {
            try
            {
                Properties properties = new Properties();
                properties.load(new FileInputStream(new File("./Conversion/dnatoaminoaciddb.txt")));
                as1[l] = properties.getProperty(as[j]);
                s1 = s1 + as1[l];
            }
            catch(Exception exception) { }
            j++;
            l++;
        }
        byte abyte0[] = s1.getBytes();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/dnatoaminoacidconv.txt"));
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }
        catch(Exception exception1) { }
    }*/
    	int slength = (s.length()/3);
       // System.out.println("slength" + slength);
        String[] s2 = new String[slength];
        String[] aSeq = new String[slength];
        System.out.println("slength" + s.length());
        System.out.println("slength" + s2.length); 
        for(int x=0, y=0; x<slength*3; x=x+3, y++ )
        {	
        	//
        	s2[y] = s.substring(x,x+3);
        	System.out.println("s2 ==" + s2[y]+"__"+y);
        }
        for (int i=0; i < s2.length ; i++)
        {
        	
        	if( s2[i].equals("ATT")  || s2[i].equals("ATC") || s2[i].equals("ATA"))
        	{
        		aSeq[i]="I";
        	}
        	else if( s2[i].equals("CTT") || s2[i].equals("CTC") || s2[i].equals("CTA")|| s2[i].equals("CTG") || s2[i].equals("TTA") || s2[i].equals("TTG"))
        	{
        		aSeq[i]="L";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("GTT") || s2[i].equals("GTC") || s2[i].equals("GTA")|| s2[i].equals("GTG"))
        	{
        		aSeq[i]="V";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("TTT") || s2[i].equals("TTC"))
        	{
        		aSeq[i]="F";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("ATG") )
        	{
        	//	System.out.println(s2[i]);
        		aSeq[i]="M";
        		
        	}
        	else if( s2[i].equals("TGT") || s2[i].equals("TGC"))
        	{
        		aSeq[i]="C";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals("GCT") || s2[i].equals("GCC")|| s2[i].equals("GCA")|| s2[i].equals("GCG" ))
        	{
        		aSeq[i]="A";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GGT") || s2[i].equals("GGC") || s2[i].equals("GGA")|| s2[i].equals("GGG" ))
        	{
        		aSeq[i]="G";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CCT") || s2[i].equals("CCC") || s2[i].equals("CCA")|| s2[i].equals("CCG"))
        	{
        		aSeq[i]="P";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "ACT" )|| s2[i].equals("ACC")|| s2[i].equals("ACA")|| s2[i].equals("ACG"))
        	{
        		aSeq[i]="T";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TCT" )|| s2[i].equals("TCC")|| s2[i].equals("TCA" )|| s2[i].equals("TCG")|| s2[i].equals("AGT")|| s2[i].equals("AGC"))
        	{
        		aSeq[i]="S";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TAT" )|| s2[i].equals("TAC"))
        	{
        		aSeq[i]="Y";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "TGG"))
        	{
        		aSeq[i]="W";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CAA" )|| s2[i].equals("CAG"))
        	{
        		aSeq[i]="Q";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "AAT" )|| s2[i].equals("AAC"))
        	{
        		aSeq[i]="N";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CAT" )|| s2[i].equals("CAC"))
        	{
        		aSeq[i]="H";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GAA" )|| s2[i].equals("GAG"))
        	{
        		aSeq[i]="E";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "GAT" )|| s2[i].equals("GAC"))
        	{
        		aSeq[i]="D";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "AAA" )|| s2[i].equals("AAG"))
        	{
        		aSeq[i]="K";
        		//System.out.println(aSeq[i]);
        	}
        	else if( s2[i].equals( "CGT"  )|| s2[i].equals("CGC")|| s2[i].equals("CGA")|| s2[i].equals("CGG")|| s2[i].equals("AGA" )|| s2[i].equals("AGG"))
        	{
        		aSeq[i]="R";
        		//System.out.println(aSeq[i]);
        	}
        	else
        	{
        		aSeq[i]="A";
        	}
    //    System.out.println(s2[i]); 
    //    System.out.println("~~~~~~~~~~~");
   //    	System.out.println( aSeq[i]);	
        }
        String sa= new String();
        for(int i=0; i<aSeq.length; i++)
        {
        	sa= sa +aSeq[i];
        	
        }
        
   //     System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        /*
        
        System.out.println("test now  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
       	char ac[] = s.toCharArray();
        //String [] s2;
        String s1 = new String();
        for(int i = 0; i < s.length(); i++)
            if(ac[i] == 'T')
                ac[i] = 'U';

        for(int j = 0; j < s.length(); j++)
            s1 = s1 + ac[j];*/
        
        byte abyte0[] = sa.getBytes();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/dnatoaminoacidconv.txt"));
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
            }
        
        catch(Exception exception) { }
    }

    public void rnatoaminoacid(String s)
    {
        char ac[] = s.toCharArray();
        String as[] = new String[s.length() / 3];
        char ac1[] = new char[3];
        int i = -1;
        int j = 0;
        for(int k = 0; k < s.length(); k++)
        {
            ac1[++i] = ac[k];
            if(i == 2)
            {
                i = -1;
                as[j] = String.valueOf(ac1);
                j++;
            }
        }

        j = 0;
        int l = 0;
        String s1 = new String();
        String as1[] = new String[s.length() / 3];
        while(j < (s.length() - 1) / 3 && (as[j] != "UAA" || as[j] != "UGA" || as[j] != "UAG"))
        {
            try
            {
                Properties properties = new Properties();
                properties.load(new FileInputStream(new File("./Conversion/rnatoaminoaciddb.txt")));
                as1[l] = properties.getProperty(as[j]);
                s1 = s1 + as1[l];
            }
            catch(Exception exception) { }
            j++;
            l++;
        }
        byte abyte0[] = s1.getBytes();
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(new File("./Conversion/rnatoaminoacidconv.txt"));
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }
        catch(Exception exception1) { }
    }
}
