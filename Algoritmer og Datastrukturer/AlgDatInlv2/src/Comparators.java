import java.util.Comparator;


public class Comparators {
    public static Comparator<FileSystem.Node> NAME = new NodeNameComparator();
    public static Comparator<FileSystem.Node> REVERSED_NAME = new NodeReversedNameComparator();
    public static Comparator<FileSystem.Node> SIZE = new NodeSizeComparator();
    public static Comparator<FileSystem.Node> REVERSED_SIZE = new NodeReversedSizeComparator();
    public static Comparator<FileSystem.Dir> NUMBER_OF_CHILDREN = new DirNumberOfChildrenComparator();
    public static Comparator<FileSystem.Dir> REVERSED_NUMBER_OF_CHILDREN = new DirReversedNumberOfChildrenComparator();
}


class NodeNameComparator implements Comparator<FileSystem.Node> {
    public int compare(FileSystem.Node a, FileSystem.Node b) {
        return String.CASE_INSENSITIVE_ORDER.compare(a.name(), b.name());
    }
}

class NodeReversedNameComparator implements Comparator<FileSystem.Node> {
    public int compare(FileSystem.Node a, FileSystem.Node b) {
        return String.CASE_INSENSITIVE_ORDER.reversed().compare(a.name(), b.name());
    }
}

class NodeSizeComparator implements Comparator<FileSystem.Node> {
    public int compare(FileSystem.Node a, FileSystem.Node b) {

        return Long.compare(a.size(), b.size());
    }
}

class NodeReversedSizeComparator implements Comparator<FileSystem.Node> {
    public int compare(FileSystem.Node a, FileSystem.Node b) {

        return Long.compare(b.size(), a.size());
    }
}

class DirNumberOfChildrenComparator implements Comparator<FileSystem.Dir> {
    public int compare(FileSystem.Dir a, FileSystem.Dir b) {
        return Long.compare(a.getDirs().size(), b.getDirs().size());
    }
}

class DirReversedNumberOfChildrenComparator implements Comparator<FileSystem.Dir> {
    public int compare(FileSystem.Dir a, FileSystem.Dir b) {
        return Long.compare( b.getDirs().size(),a.getDirs().size());
    }
}

/*
 * May be useful for those of you who want to follow
 * up "Tips 3: Egen klasse for reversert komparator".
 */
class ReversedComparator<T> implements Comparator<T> {
    // TODO: Turn this into something useful.
    Comparator<T> originalComparator;

    ReversedComparator(Comparator<T> cmp) {
        originalComparator = cmp;
    }

    public int compare(T a, T b) {
        return 0;
    }
}




