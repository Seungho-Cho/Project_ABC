package com.bitacademy.util;

public class PageUtil {
	private static int MAX_PAGE_INDEX = 10;

	private static String HEADER = "Result page";

	public static String generate(int page, int size, int length, String url) {
		// 필요한 데이터가 없으면 "" 을 리턴한다.
		if (page <= 0 || length <= 0 || MAX_PAGE_INDEX <= 0) {
			return "";
		}

		String pref;
		if (url.indexOf("?") > -1) {
			pref = "&";
		} else {
			pref = "?";
		}

		int totalPage = size / length;
		if (size % length > 0) {
			totalPage++;
		}
		if (totalPage <= 0)
			totalPage = 1;

		int currentPageCount = page / MAX_PAGE_INDEX;
		if (page % MAX_PAGE_INDEX > 0) {
			currentPageCount++;
		}

		int lastPageCount = totalPage / MAX_PAGE_INDEX;
		if (totalPage % MAX_PAGE_INDEX > 0) {
			lastPageCount++;

		}
		int startPage = (currentPageCount - 1) * MAX_PAGE_INDEX + 1;
		int endPage = (currentPageCount - 1) * MAX_PAGE_INDEX + MAX_PAGE_INDEX;
		if (endPage > totalPage) {
			endPage = totalPage;

		}

		StringBuffer header = new StringBuffer();
		header.append(HEADER + ": ");

		if (startPage > MAX_PAGE_INDEX) {
			header.append("<a href='");
			header.append(url);
			header.append(pref);
			header.append("page=1");
			header.append("'>");
			header.append("First");
			header.append("</a>&nbsp;");

		}

		if (page > 1) {
			header.append("<a href='");
			header.append(url);
			header.append(pref);
			header.append("page=" + (page - 1));
			header.append("'>");
			header.append("Prev");
			header.append("</a>&nbsp;");
		}

		if (startPage > MAX_PAGE_INDEX) {
			header.append("<a href='");

			int prev = page - MAX_PAGE_INDEX;
			if (prev <= 0) {
				prev = 1;
			}
			header.append(url);
			header.append(pref);
			header.append("page=" + prev);
			header.append("'>");
			header.append("[...]");
			header.append("</a>&nbsp;");
		}

		for (int i = startPage; i <= endPage; i++) {
			if (i != page) {
				header.append("<a href='");
				header.append(url);
				header.append(pref);
				header.append("page=" + i);
				header.append("'>");
				header.append(i);
				header.append("</a>&nbsp;");
			} else {
				header.append("<b>");
				header.append(i);
				header.append("</b>&nbsp;");
			}
		}

		if (currentPageCount < lastPageCount) {
			header.append("<a href='");

			int next = page + MAX_PAGE_INDEX;
			if (next > totalPage) {
				next = totalPage;
			}
			header.append(url);
			header.append(pref);
			header.append("page=" + next);

			header.append("'>");
			header.append("[...]");
			header.append("</a>&nbsp;");
		}

		if (page < totalPage) {
			header.append("<a href='");
			header.append(url);
			header.append(pref);
			header.append("page=" + (page + 1));
			header.append("'>");
			header.append("Next");
			header.append("</a>&nbsp;");
		}

		if (currentPageCount < lastPageCount) {
			header.append("<a href='");
			header.append(url);
			header.append(pref);
			header.append("page=" + totalPage);
			header.append("'>");
			header.append("Last");
			header.append("</a>&nbsp;");
		}
		//System.out.println(header.toString());

		return header.toString();
	}

}
