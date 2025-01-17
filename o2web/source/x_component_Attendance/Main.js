MWF.xApplication.Attendance = MWF.xApplication.Attendance || {};
MWF.require("MWF.widget.O2Identity", null, false);
//MWF.xDesktop.requireApp("Attendance", "Actions.RestActions", null, false);
MWF.xDesktop.requireApp("Attendance", "Common", null, false);
MWF.xDesktop.requireApp("Attendance", "Explorer", null, false);
MWF.xDesktop.requireApp("Template", "MDomItem", null, false);
MWF.xApplication.Attendance.options = {
	multitask: false,
	executable: true
};
MWF.xApplication.Attendance.Main = new Class({
	Extends: MWF.xApplication.Common.Main,
	Implements: [Options, Events],

	options: {
		"curNaviId": null,
		"style": "default",
		"name": "Attendance",
		"icon": "icon.png",
		"width": "1400",
		"height": "700",
		"isResize": true,
		"isMax": true,
		"title": MWF.xApplication.Attendance.LP.title
	},
	onQueryLoad: function () {
		this.lp = MWF.xApplication.Attendance.LP;
	},
	loadApplication: function (callback) {
		if (!this.options.isRefresh) {
			this.maxSize(function () {
				this.loadLayout();
			}.bind(this));
		} else {
			this.loadLayout();
		}
	},
	loadLayout: function () {
		this.manageUnits = [];
		this.manageTopUnits = [];
		this.enableType = "";

		this.restActions = MWF.Actions.get("x_attendance_assemble_control");
		this.personActions = MWF.Actions.get("x_organization_assemble_personal");
		this.orgActions = MWF.Actions.get("x_organization_assemble_express");

		this.content.loadCss("../x_desktop/css/element-icons.css");

		this.createNode();
		this.loadApplicationContent();
	},
	isAdmin: function () {
		return this.isTopUnitManager() || MWF.AC.isAttendanceManager() || MWF.AC.isAdministrator()
	},
	isUnitManager: function () {
		return this.manageUnits.length > 0;
	},
	isTopUnitManager: function () {
		return this.manageTopUnits.length > 0;
	},
	getNameFlag: function (name) {
		var t = typeOf(name);
		if (t === "array") {
			var v = [];
			name.each(function (id) {
				v.push((typeOf(id) === "object") ? (id.distinguishedName || id.id || id.unique || id.name) : id);
			});
			return v;
		} else {
			return [(t === "object") ? (name.distinguishedName || name.id || name.unique || name.name) : name];
		}
	},
	loadController: function (callback) {
		this.restActions.listPermission(function (json) {
			json.data = json.data || [];
			json.data.each(function (item) {
				if (item.adminLevel == "COMPANY" && item.adminName == layout.desktop.session.user.distinguishedName) {
					this.manageTopUnits.push(item.unitName)
				} else if (item.adminLevel == "DEPT" && item.adminName == layout.desktop.session.user.distinguishedName) {
					this.manageUnits.push(item.unitName)
				}
			}.bind(this));
			if (callback) callback(json);
		}.bind(this));
	},
	loadEnableType: function (callback) {
		var action = o2.Actions.load("x_attendance_assemble_control");
		action.AttendanceSettingAction.enableType(//平台封装好的方法
			function (json) { //服务调用成功的回调函数, json为服务传回的数据
				if (json.data && json.data.value) {
					debugger;
					this.enableType = json.data.value;
				}
				if (callback) callback(json);
			}.bind(this));
	},
	createNode: function () {
		this.content.setStyle("overflow", "hidden");
		this.node = new Element("div", {
			"styles": { "width": "100%", "height": "100%", "overflow": "hidden" }
		}).inject(this.content);
	},
	loadApplicationContent: function () {
		this.loadController(function () {
			this.loadEnableType(function () {
				this.loaNavi();
			}.bind(this));
		}.bind(this));
		//this.loadApplicationLayout();
	},
	loaNavi: function (callback) {
		this.naviNode = new Element("div.naviNode", {
			"styles": this.css.naviNode
		}).inject(this.node);

		var curNavi = { "id": "" };
		if (this.status) {
			curNavi.id = this.status.id
		}
		if (this.options.curNaviId) {
			curNavi.id = this.options.curNaviId;
		}
		this.navi = new MWF.xApplication.Attendance.Navi(this, this.naviNode, curNavi);
	},
	clearContent: function () {
		if (this.explorerContent) {
			if (this.explorer && this.explorer.destroy) {
				this.explorer.destroy();
			}
			this.explorerContent.destroy();
			this.explorerContent = null;
		}
	},
	openMyIndex: function () {
		MWF.xDesktop.requireApp("Attendance", "MyIndex", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.MyIndex(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openMyDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "MyDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.MyDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openUnitIndex: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitIndex", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitIndex(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openUnitDingdingIndex: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitDingdingIndex", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitDingdingIndex(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openUnitQywxIndex: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitQywxIndex", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitQywxIndex(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openUnitDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	
	openDingdingUnitDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitDingdingDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitDingdingDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openQywxUnitDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "UnitQywxDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.UnitQywxDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openPeopleDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "PeopleDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.PeopleDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openDingdingPeopleDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "PeopleDingdingDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.PeopleDingdingDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openQywxPeopleDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "PeopleQywxDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.PeopleQywxDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openTopUnitDetail: function () {
		MWF.xDesktop.requireApp("Attendance", "TopUnitDetail", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.TopUnitDetail(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openSelfHoliday: function () {
		MWF.xDesktop.requireApp("Attendance", "SelfHoliday", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.SelfHoliday(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openMyAppealDeal: function () {
		MWF.xDesktop.requireApp("Attendance", "MyAppeal", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.MyAppeal(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openAppealDeal: function () {
		MWF.xDesktop.requireApp("Attendance", "AppealExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.AppealExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openImporting: function () {
		MWF.xDesktop.requireApp("Attendance", "ImportExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.ImportExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openImportedInvalidInfor: function () {
		MWF.xDesktop.requireApp("Attendance", "InvalidInfor", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.InvalidInfor(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openAbnormalExport: function () {
		MWF.xDesktop.requireApp("Attendance", "AbnormalExport", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.AbnormalExport(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openScheduleSetting: function () {
		MWF.xDesktop.requireApp("Attendance", "ScheduleExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.ScheduleExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openPermissionSetting: function () {
		MWF.xDesktop.requireApp("Attendance", "PermissionExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.PermissionExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openHolidaySetting: function () {
		MWF.xDesktop.requireApp("Attendance", "HolidayExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.HolidayExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openStaticsCycleExplorer: function () {
		MWF.xDesktop.requireApp("Attendance", "StatisticsCycle", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.StatisticsCycle(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openAppSetting: function () {
		MWF.xDesktop.requireApp("Attendance", "AppSetting", function () {
			var setting = new MWF.xApplication.Attendance.AppSetting({app: this});
			setting.edit();
		}.bind(this));
	},
	openWeekendSetting : function(){
		MWF.xDesktop.requireApp("Attendance", "WeekendSetting", function(){
			var setting = new MWF.xApplication.Attendance.WeekendSetting({app: this});
			setting.edit();
		}.bind(this));
	},
	openAddressSetting: function () {
		MWF.xDesktop.requireApp("Attendance", "AddressExplorer", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.AddressExplorer(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	openPersonSetting: function () {
		MWF.xDesktop.requireApp("Attendance", "PersonSetting", function () {
			this.clearContent();
			this.explorerContent = new Element("div", {
				"styles": this.css.rightContentNode
			}).inject(this.node);
			this.explorer = new MWF.xApplication.Attendance.PersonSetting(this.explorerContent, this, this.restActions, { "isAdmin": this.isAdmin() });
			this.explorer.load();
		}.bind(this));
	},
	recordStatus: function () {
		return this.navi && this.navi.currentItem ? this.navi.currentItem.retrieve("data") : {};
	}
});



MWF.xApplication.Attendance.Navi = new Class({
	Implements: [Options, Events],
	options: {
		"id": ""
	},
	initialize: function (app, node, options) {
		this.setOptions(options);
		this.app = app;
		this.node = $(node);
		this.css = this.app.css;
		this.currentMenu = null;
		this.currentItem = null;
		this.menus = {};
		this.items = {};
		this.elements = [];
		this.load();
	},
	load: function () {
		this.scrollNode = new Element("div.naviScrollNode", { "styles": this.css.naviScrollNode }).inject(this.node);
		this.areaNode = new Element("div.naviAreaNode", { "styles": this.css.naviAreaNode }).inject(this.scrollNode);

		// this.setNodeScroll();

		var naviUrl = this.app.path + "navi.json";
		MWF.getJSON(naviUrl, function (json) {
			json.each(function (navi) {
				if (navi.access && navi.access == "admin") {
					if (this.app.isAdmin()) this.createNaviNode(navi);
				} else if (navi.access && navi.access == "admin_dept") {
					if (this.app.isUnitManager() || this.app.isAdmin()) this.createNaviNode(navi);
				} else if (navi.access && navi.access == "dingding") { //启用钉钉考勤同步后
					debugger;
					if ((this.app.isUnitManager() || this.app.isAdmin()) && (this.app.enableType == "dingding")) this.createNaviNode(navi);
				} else if (navi.access && navi.access == "qywx") { // 启用企业微信考勤同步后
					debugger;
					if ((this.app.isUnitManager() || this.app.isAdmin()) && (this.app.enableType == "qywx")) this.createNaviNode(navi);
				} else {
					this.createNaviNode(navi);
				}
			}.bind(this));

			if (this.options.id == "") this.elements[1].click();

			this.setContentSize();

			this.app.addEvent("resize", this.setContentSize.bind(this));
		}.bind(this));
	},
	// setNodeScroll: function () {
	// 	MWF.require("MWF.widget.DragScroll", function () {
	// 		new MWF.widget.DragScroll(this.scrollNode);
	// 	}.bind(this));
	// 	MWF.require("MWF.widget.ScrollBar", function () {
	// 		new MWF.widget.ScrollBar(this.scrollNode, { "indent": false });
	// 	}.bind(this));
	// },
	createNaviNode: function (data) {
		if (data.type == "sep") {
			var flag = true;
			if (data.access == "admin") {
				if (!this.app.isAdmin()) flag = false;
			} else if (data.access && data.access == "admin_dept") {
				if (!this.app.isUnitManager() && !this.app.isAdmin()) flag = false;
			}
			if (flag) {
				new Element("div", { "styles": this.css.viewNaviSepartorNode }).inject(this.areaNode);
			}
		} else if (data.sub && data.sub.length > 0) {
			this.createNaviMenuNode(data);
		} else {
			this.menus[data.id] = {};
			this.createNaviItemNode(data, data.id);
		}
	},
	createNaviMenuNode: function (data) {
		if (data.access == "admin") {
			if (!this.app.isAdmin()) return;
		} else if (data.access == "admin_dept") {
			if (!this.app.isUnitManager() && !this.app.isAdmin()) return;
		}
		var _self = this;
		var menuNode = new Element("div", {
			"styles": this.css.naviMenuNode
		});
		menuNode.store("data", data);
		menuNode.store("type", "menu");

		var textNode = new Element("div", {
			"styles": this.css.naviMenuTextNode,
			"text": data.title
		});
		textNode.inject(menuNode);
		menuNode.inject(this.areaNode);

		this.menus[data.id] = {};
		this.menus[data.id].node = menuNode;
		this.elements.push(menuNode);

		menuNode.addEvents({
			"mouseover": function () { if (_self.currentMenu != this){
				this.setStyles(_self.app.css.naviMenuNode_over);
				this.addClass("mainColor_bg_opacity");
            }},
			"mouseout": function () { if (_self.currentMenu != this){
				this.setStyles(_self.app.css.naviMenuNode_normal);
				this.removeClass("mainColor_bg_opacity");
			}},
			// "mousedown": function () { if (_self.currentMenu != this) this.setStyles(_self.app.css.naviMenuNode_down); },
			// "mouseup": function () { if (_self.currentMenu != this) this.setStyles(_self.app.css.naviMenuNode_over); },
			"click": function () {
				//if (_self.currentNavi!=this) _self.doAction.apply(_self, [this]);
				_self.clickMenu.apply(_self, [this]);
			}
		});

		data.sub.each(function (d) {
			this.createNaviItemNode(d, data.id, menuNode)
		}.bind(this))
	},
	clickMenu: function (naviNode) {
		var navi = naviNode.retrieve("data");
		var action = navi.action;

		var collapse = naviNode.retrieve("collapse");

		// this.closeCurrentMenu();
		if (this.menus[navi.id].itemNodes) {
			this.menus[navi.id].itemNodes.each(function (itemNode) {
				itemNode.setStyle("display", collapse ? "block" : "none");
			})
		}

		// var type = naviNode.retrieve("type");
		if (!navi.target || navi.target != "_blank") {
			naviNode.setStyles(collapse ? this.css.naviMenuNode : this.css.naviMenuNode_collapse );
			// this.currentMenu = naviNode;
		}

		naviNode.store("collapse", !collapse);
	},
	// closeCurrentMenu: function () {
	// 	if (this.currentMenu) {
	// 		var data = this.currentMenu.retrieve("data");
	// 		if (this.menus[data.id].itemNodes) {
	// 			this.menus[data.id].itemNodes.each(function (itemNode) {
	// 				itemNode.setStyle("display", "none");
	// 			})
	// 		}
	// 		this.currentMenu.setStyles(this.css.naviMenuNode);
	// 	}
	// },
	createNaviItemNode: function (data, menuId) {

		if (data.access == "admin") {
			if (!this.app.isAdmin()) return;
		} else if (data.access && data.access == "admin_dept") {
			if (!this.app.isUnitManager() && !this.app.isAdmin()) return;
		}

		var _self = this;

		var items = this.menus[menuId].itemNodes = this.menus[menuId].itemNodes || [];

		var itemNode = new Element("div", {
			"styles": this.css.naviItemNode
		});
		itemNode.setStyle("display", "block");

		items.push(itemNode);
		itemNode.store("data", data);
		itemNode.store("type", "item");

		var textNode = new Element("div", {
			"styles": this.css.naviItemTextNode,
			"text": data.title
		});
		textNode.inject(itemNode);

		itemNode.inject(this.areaNode);

		this.elements.push(itemNode);
		this.items[data.id] = itemNode;

		itemNode.addEvents({
			"mouseover": function () { if (_self.currentItem != this) {
				this.setStyles(_self.app.css.naviItemNode_over);
				this.addClass("mainColor_bg_opacity");
			} },
			"mouseout": function () { if (_self.currentItem != this) {
				this.setStyles(_self.app.css.naviItemNode);
				this.removeClass("mainColor_bg_opacity");
			} },
			"mousedown": function () { if (_self.currentItem != this) {
				this.setStyles(_self.app.css.naviItemNode_down);
				this.addClass("mainColor_color");
				this.addClass("mainColor_bg_opacity");
			} },
			"mouseup": function () { if (_self.currentItem != this) {
				this.setStyles(_self.app.css.naviItemNode_over);
				this.removeClass("mainColor_color");
				this.removeClass("mainColor_bg_opacity");
			} },
			"click": function () {
				_self.clickItem.apply(_self, [this]);
			}
		});

		if (data.id == this.options.id) {
			itemNode.click();
		}
	},
	clickItem: function (naviNode) {
		var navi = naviNode.retrieve("data");
		var action = navi.action;

		var type = naviNode.retrieve("type");
		if (!navi.target || navi.target != "_blank") {
			if (this.currentItem) {
				this.currentItem.setStyles(this.css.naviItemNode);
				this.currentItem.removeClass("mainColor_color");
				this.currentItem.removeClass("mainColor_bg_opacity");
			}
			naviNode.setStyles(this.css.naviItemNode_current);
			naviNode.addClass("mainColor_color");
			naviNode.addClass("mainColor_bg_opacity");
			this.currentItem = naviNode;
		}

		if (navi.action && this.app[navi.action]) {
			this.app[navi.action].call(this.app, navi);
		}
	},
	setContentSize: function () {
		var size = this.app.content.getSize();
		this.scrollNode.setStyle("height", size.y - 5);
	}
	//loadCalendar: function () {
	//	var calendarArea = new Element("div#calendarArea",{
	//		"styles" : this.css.calendarArea
	//	}).inject(this.node)
	//	this.calendar = new MWF.xApplication.Attendance.Calendar( calendarArea, this.app, this.actions )
	//	this.calendar.load();
	//}
});
