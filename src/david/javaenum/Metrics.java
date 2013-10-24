package david.javaenum;

public enum Metrics {
	PV, Clicks, CTR, UV, ROI, eCPM, eCPC, CPS, CPA;

	public String toString() {
		return getDescription();
	};

	public String getDescription() {
		String[] descs = new String[]{"印象数", "点击数", "点击率", "独立用户数", "利润最大化",
				"千次印象成本", "点击成本呢", "按销售购买", "按行为购买"};
		return descs[this.ordinal()];
	}
}
