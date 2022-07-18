
import java.text.SimpleDateFormat;
import java.util.Date;

class Lost{
	private String lostId;// 失物编号
	private String lostName;// 失物名称
	private Date date;//丢失时间
	private String lostAddress;// 丢失地点
	private String lostByName;// 丢失者姓名
	private String lostByPhone;// 丢失者电话
	public Lost(String lostId, String lostName, Date date, String lostAddress, String lostByName, String lostByPhone) {
		super();
		this.lostId = lostId;
		this.lostName = lostName;
		this.date = date;
		this.lostAddress = lostAddress;
		this.lostByName = lostByName;
		this.lostByPhone = lostByPhone;
	}
	public String getLostId() {
		return lostId;
	}
	public void setLostId(String lostId) {
		this.lostId = lostId;
	}
	public String getLostName() {
		return lostName;
	}
	public void setLostName(String lostName) {
		this.lostName = lostName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLostAddress() {
		return lostAddress;
	}
	public void setLostAddress(String lostAddress) {
		this.lostAddress = lostAddress;
	}
	public String getLostByName() {
		return lostByName;
	}
	public void setLostByName(String lostByName) {
		this.lostByName = lostByName;
	}
	public String getLostByPhone() {
		return lostByPhone;
	}
	public void setLostByPhone(String lostByPhone) {
		this.lostByPhone = lostByPhone;
	}
	
	
}
class CardLost extends Lost{
	private String cardNumber;// 卡号
	private String cardByName;// 卡主姓名
	public CardLost(String lostId, String lostName, Date date, String lostAddress, String lostByName,
			String lostByPhone, String cardNumber, String cardByName) {
		super(lostId, lostName, date, lostAddress, lostByName, lostByPhone);
		this.cardNumber = cardNumber;
		this.cardByName = cardByName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardByName() {
		return cardByName;
	}
	public void setCardByName(String cardByName) {
		this.cardByName = cardByName;
	}
	
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "BookLost [LostId=" + getLostId() + ", LostName="
				+ getLostName() + ", Date=" + df.format(getDate()) + ",LostAddress=" + getLostAddress()
				+ ", LostByName=" + getLostByName() + ", LostByPhone=" + getLostByPhone() + "cardNumber= "+cardNumber + ", cardByName=" + cardByName + " ]";
	}
}
class BookLost extends Lost{
	private String isbn;// 书编号
	private String bookName;// 书名
	public BookLost(String lostId, String lostName, Date date, String lostAddress, String lostByName,
			String lostByPhone, String isbn, String bookName) {
		super(lostId, lostName, date, lostAddress, lostByName, lostByPhone);
		this.isbn = isbn;
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "BookLost [LostId=" + getLostId() + ", LostName="
				+ getLostName() + ", Date=" + df.format(getDate()) + ",LostAddress=" + getLostAddress()
				+ ", LostByName=" + getLostByName() + ", LostByPhone=" + getLostByPhone() + "isbn= "+isbn + ", bookName=" + bookName + " ]";
	}
	
	
}
public class Solution{
	
	public void sortLost(Lost[] lostArray) {
		 for (int i=0;i<lostArray.length-1;i++){
	            for (int j=0;j<lostArray.length-i-1;j++){
	                if(lostArray[j]!=null && lostArray[j+1]!=null && lostArray[j].getDate().compareTo(lostArray[j+1].getDate())>0){
	                    Lost temp = lostArray[j+1];
	                    lostArray[j+1] = lostArray[j];
	                    lostArray[j] = temp;
	                }
	            }
	        }
		
	}
	
	public Lost[] selectByKeyword(Lost[] lostArray,String keyword) {
		Lost[] returnLost = new Lost[5];
		int i=0;
		for (int j = 0; j < returnLost.length; j++) {
			if(lostArray[j].getLostName().contains(keyword)) {
				returnLost[i]=lostArray[j];
				i++;
			}
		}
		return returnLost;
		
	}
	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Lost[] lostArray = new Lost[5];
		BookLost lost1 = new BookLost("1", "鲁滨孙漂流记",df.parse("2022-02-01"), "北京市朝阳区望京宜家", "张三", "15108989899", "12345", "鲁滨孙漂流记");
		lostArray[0]=lost1;
		BookLost lost2 = new BookLost("2", "红楼梦",df.parse("2022-06-06"), "北京市海淀区西土城地铁站", "李四", "17667675645", "34567", "红楼梦");
		lostArray[1]=lost2;
		BookLost lost3 = new BookLost("3", "校园一卡通202100003",df.parse("2022-05-25"), "北京市西城区西单大悦城5层", "王五", "18234567890", "202100003", "王五");
		lostArray[2]=lost3;
		BookLost lost4 = new BookLost("4", "校园一卡通202100002",df.parse("2022-04-01"), "北京市顺义区 环球影城","钱六", "13178785656", "202100002", "钱六");
		lostArray[3]=lost4;
		BookLost lost5 = new BookLost("5", "校园一卡通202100001",df.parse("2022-03-31"), "北京市丰台区良乡大学城", "冯七", "17845390987", "202100001", "冯七");
		lostArray[4]=lost5;
		Solution s = new Solution();
		s.sortLost(lostArray);
		for (int i = 0; i < lostArray.length; i++) {
			System.out.println(lostArray[i]);
		}
		Lost[] selectByKeyword = s.selectByKeyword(lostArray, "红楼");
		for (int i = 0; i < selectByKeyword.length; i++) {
			if(selectByKeyword[i]!=null) {
				System.out.println(selectByKeyword[i]);
			}
		}
		
	}
	
}