package subjects;

public abstract class Equipment extends Subject {
	public abstract void startEffect(Virologist virologist);

	public abstract void endEffect(Virologist virologist);

	public abstract String toString();
}
