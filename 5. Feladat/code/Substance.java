
/**
* substance osztaly
*/
public abstract class Substance {
    public boolean isSame(Substance s) {
		if(this.getClass() == s.getClass())
			return true;
		return false;
	}

    public void Pickup(){}
}
