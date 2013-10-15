package david.javaio;

import java.util.Calendar;

public class SearchedFile implements Comparable<SearchedFile> {
	private String _fileName;
	private Calendar _lastModifed;

	public SearchedFile(String fileName, Calendar lastModified) {
		// TODO Auto-generated constructor stub
		_fileName = fileName;
		_lastModifed = lastModified;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("{文件名：%s, 最后修改时间：%s}", _fileName, _lastModifed
				.getTime().toString());
	}

	@Override
	public int compareTo(SearchedFile o) {
		// TODO Auto-generated method stub
		if (o == null)
			return -1;

		return _lastModifed.compareTo(o._lastModifed) > 0 ? -1 : 1;
	}
}
