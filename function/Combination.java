class Combination {
    private int n;
    private int r;
    private int[] now;
    private List<List<String>> result;

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public List<List<String>> getResult() {
        return result;
    }

    public void combination(List<String> arr, int depth, int index, int target) {
        if (depth == r) {
            List<String> temp = new ArrayList<>();
            for (int num : now) {
                temp.add(arr.get(num));
            }
            result.add(temp);
            return;
        }

        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}
