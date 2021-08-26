package com.deng.booklist.form;

public interface FormConvert<S, T> {
	T convert(S s);
}
