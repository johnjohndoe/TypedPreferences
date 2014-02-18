package info.metadude.android.typedpreferences;

public interface TypedPreference<T extends Object> {

    public T get();
    public boolean isSet();
    public void set(T value);
    public void delete();

}
