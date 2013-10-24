package david.javaenum;

public enum Metrics {
	PV, Clicks, CTR, UV, ROI, eCPM, eCPC, CPS, CPA;

	public String toString() {
		return getDescription();
	};

	public String getDescription() {
		String[] descs = new String[]{"ӡ����", "�����", "�����", "�����û���", "�������",
				"ǧ��ӡ��ɱ�", "����ɱ���", "�����۹���", "����Ϊ����"};
		return descs[this.ordinal()];
	}
}
