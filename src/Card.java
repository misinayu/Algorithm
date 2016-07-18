
public class Card {
	public String mark;
	public int number;
	
	public Card(String mark, int number) {
		this.mark = mark;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return mark + " " + number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (!(obj instanceof Card)) { return false; }
		Card card = (Card) obj;
		if ((this.mark.equals(card.mark)) && 
				(this.number == card.number)) {
			return true;
		}
		return false;
	}
}
