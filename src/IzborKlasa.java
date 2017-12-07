
public class IzborKlasa {
 public KeteringTim izaberi(String s){
	 KeteringTim k=null;
	 if(s.equalsIgnoreCase(Forma3.IT)){
		 k=new TimItalija();
	 }
	 else if(s.equalsIgnoreCase(Forma3.SRB)){
		 k=new TimSrbija();
	 }
	 return k;
 }
}
