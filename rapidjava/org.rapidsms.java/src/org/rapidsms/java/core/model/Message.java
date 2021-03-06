/*
 * Copyright (C) 2009 Dimagi Inc., UNICEF
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.rapidsms.java.core.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Daniel Myung dmyung@dimagi.com
 * @created Jan 26, 2009 Summary:
 */
public class Message {

	public static final int COL_ID = 0;
	// do not use
	// public static final int COL_PHONE = 1;
	public static final int COL_MONITOR = 2;
	public static final int COL_TIME = 3;
	public static final int COL_MESSAGE = 4;
	public static final int COL_IS_OUTGOING = 5;
	public static final int COL_IS_VIRTUAL = 6;
	public static final int COL_RECEIVE_TIME = 7;

	public static final int COL_PARSED_ID = 0;
	public static final int COL_PARSED_MESSAGE_ID = 1;
	public static final int COL_PARSED_FIELDS_OFFSET = 2;

	public static final int COL_JOINED_PHONE = -1;
	public static final int COL_JOINED_MESSAGE_TIME = -2;
	public static final int COL_JOINED_MESSAGE = -3;

	// 2009-01-29 20:44:30
	/**
	 * Formats the message to a string that SQLite likes: (yyyy-MM-dd HH:mm:ss)
	 * in the current machine's timezone.
	 */
	public static DateFormat SQLDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * Format the timestamp to a displayable format in the UI HH:mm MM/dd/yy
	 */
	public static DateFormat DisplayDateTimeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	public static DateFormat DisplayShortDateFormat = new SimpleDateFormat("MM/dd/yyyy");

	public Message(int id, String message, Date timestamp, Monitor monitor, Date recvtime) {
		this.mId = id;
		this.mMessageText = message;
		this.mMonitor = monitor;
		this.mTimestamp = timestamp;
		this.mReceiveTime = recvtime;
	}

	/**
	 * @return the mMessageText
	 */
	public String getMessageText() {
		return mMessageText;
	}

	/**
	 * Get the timestamp for the given message
	 * 
	 * @return the mTimestamp
	 */
	public Date getTimestamp() {
		return mTimestamp;
	}

	/**
	 * @return the mMonitorPhone
	 */
	public Monitor getMonitor() {
		return mMonitor;
	}

	/**
	 * @return the id
	 */
	public int getID() {
		return mId;
	}

	private int mId;
	private String mMessageText;
	private Date mTimestamp;
	private Monitor mMonitor;
	private Date mReceiveTime;

}
