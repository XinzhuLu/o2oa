package com.x.processplatform.assemble.surface.wrapout.content;

import java.util.ArrayList;
import java.util.List;

import com.x.base.core.entity.JpaObject;
import com.x.processplatform.assemble.surface.WorkControl;
import com.x.processplatform.core.entity.content.Task;

public class WrapOutTask extends Task {

	private static final long serialVersionUID = 2279846765261247910L;

	public static List<String> Excludes = new ArrayList<>(JpaObject.FieldsInvisible);

	private Long rank;

	private WorkControl control;

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public WorkControl getControl() {
		return control;
	}

	public void setControl(WorkControl control) {
		this.control = control;
	}

}
