package com.project.interview1.apiservice.pojos.read_items_by_section;

import java.util.List;

public class Response{
	private String result;
	private int size;
	private List<DetailsCatItem> detailsCat;
	private List<DetailsSizItem> detailsSiz;
	private List<DetailsItem> details;
	private List<DetailsBraItem> detailsBra;
	private String message;
	private List<DetailsColItem> detailsCol;

	public String getResult(){
		return result;
	}

	public int getSize(){
		return size;
	}

	public List<DetailsCatItem> getDetailsCat(){
		return detailsCat;
	}

	public List<DetailsSizItem> getDetailsSiz(){
		return detailsSiz;
	}

	public List<DetailsItem> getDetails(){
		return details;
	}

	public List<DetailsBraItem> getDetailsBra(){
		return detailsBra;
	}

	public String getMessage(){
		return message;
	}

	public List<DetailsColItem> getDetailsCol(){
		return detailsCol;
	}
}