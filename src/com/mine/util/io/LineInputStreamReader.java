package com.mine.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LineInputStreamReader extends BufferedReader {

	private Reader in;

	public LineInputStreamReader(Reader in) {
		super(in);
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

}
