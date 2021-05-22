package editors;

import java.util.List;

public interface Editor {
    public abstract void setInfo(List<String> info);
    public abstract void checkAndApplyChanges();
    public abstract void delete();
}
