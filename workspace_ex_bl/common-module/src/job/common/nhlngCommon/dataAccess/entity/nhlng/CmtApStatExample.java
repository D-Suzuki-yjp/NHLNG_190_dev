package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CmtApStatExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    protected Criteria criteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public CmtApStatExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    public Criteria addCriteria() {
            oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSccServerNameIsNull() {
            addCriterion("scc_server_name is null");
            return (Criteria) this;
        }

        public Criteria andSccServerNameIsNotNull() {
            addCriterion("scc_server_name is not null");
            return (Criteria) this;
        }

        public Criteria andSccServerNameEqualTo(String value) {
            addCriterion("scc_server_name =", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotEqualTo(String value) {
            addCriterion("scc_server_name <>", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameGreaterThan(String value) {
            addCriterion("scc_server_name >", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("scc_server_name >=", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLessThan(String value) {
            addCriterion("scc_server_name <", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLessThanOrEqualTo(String value) {
            addCriterion("scc_server_name <=", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameLike(String value) {
            addCriterion("scc_server_name like", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotLike(String value) {
            addCriterion("scc_server_name not like", value, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameIn(List<String> values) {
            addCriterion("scc_server_name in", values, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotIn(List<String> values) {
            addCriterion("scc_server_name not in", values, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameBetween(String value1, String value2) {
            addCriterion("scc_server_name between", value1, value2, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andSccServerNameNotBetween(String value1, String value2) {
            addCriterion("scc_server_name not between", value1, value2, "sccServerName");
            return (Criteria) this;
        }

        public Criteria andApNameIsNull() {
            addCriterion("ap_name is null");
            return (Criteria) this;
        }

        public Criteria andApNameIsNotNull() {
            addCriterion("ap_name is not null");
            return (Criteria) this;
        }

        public Criteria andApNameEqualTo(String value) {
            addCriterion("ap_name =", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameNotEqualTo(String value) {
            addCriterion("ap_name <>", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameGreaterThan(String value) {
            addCriterion("ap_name >", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameGreaterThanOrEqualTo(String value) {
            addCriterion("ap_name >=", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameLessThan(String value) {
            addCriterion("ap_name <", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameLessThanOrEqualTo(String value) {
            addCriterion("ap_name <=", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameLike(String value) {
            addCriterion("ap_name like", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameNotLike(String value) {
            addCriterion("ap_name not like", value, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameIn(List<String> values) {
            addCriterion("ap_name in", values, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameNotIn(List<String> values) {
            addCriterion("ap_name not in", values, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameBetween(String value1, String value2) {
            addCriterion("ap_name between", value1, value2, "apName");
            return (Criteria) this;
        }

        public Criteria andApNameNotBetween(String value1, String value2) {
            addCriterion("ap_name not between", value1, value2, "apName");
            return (Criteria) this;
        }

        public Criteria andApStatIsNull() {
            addCriterion("ap_stat is null");
            return (Criteria) this;
        }

        public Criteria andApStatIsNotNull() {
            addCriterion("ap_stat is not null");
            return (Criteria) this;
        }

        public Criteria andApStatEqualTo(Integer value) {
            addCriterion("ap_stat =", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotEqualTo(Integer value) {
            addCriterion("ap_stat <>", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThan(Integer value) {
            addCriterion("ap_stat >", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_stat >=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThan(Integer value) {
            addCriterion("ap_stat <", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThanOrEqualTo(Integer value) {
            addCriterion("ap_stat <=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatIn(List<Integer> values) {
            addCriterion("ap_stat in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotIn(List<Integer> values) {
            addCriterion("ap_stat not in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat not between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatFlgIsNull() {
            addCriterion("ap_stat_flg is null");
            return (Criteria) this;
        }

        public Criteria andApStatFlgIsNotNull() {
            addCriterion("ap_stat_flg is not null");
            return (Criteria) this;
        }

        public Criteria andApStatFlgEqualTo(Integer value) {
            addCriterion("ap_stat_flg =", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgNotEqualTo(Integer value) {
            addCriterion("ap_stat_flg <>", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgGreaterThan(Integer value) {
            addCriterion("ap_stat_flg >", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_stat_flg >=", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgLessThan(Integer value) {
            addCriterion("ap_stat_flg <", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgLessThanOrEqualTo(Integer value) {
            addCriterion("ap_stat_flg <=", value, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgIn(List<Integer> values) {
            addCriterion("ap_stat_flg in", values, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgNotIn(List<Integer> values) {
            addCriterion("ap_stat_flg not in", values, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat_flg between", value1, value2, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatFlgNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_stat_flg not between", value1, value2, "apStatFlg");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeIsNull() {
            addCriterion("ap_stat_upd_dtime is null");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeIsNotNull() {
            addCriterion("ap_stat_upd_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime =", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime <>", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime >", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime >=", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeLessThan(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime <", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ap_stat_upd_dtime <=", value, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ap_stat_upd_dtime in", values, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ap_stat_upd_dtime not in", values, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ap_stat_upd_dtime between", value1, value2, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andApStatUpdDtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ap_stat_upd_dtime not between", value1, value2, "apStatUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIsNull() {
            addCriterion("last_upd_user is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIsNotNull() {
            addCriterion("last_upd_user is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserEqualTo(String value) {
            addCriterion("last_upd_user =", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotEqualTo(String value) {
            addCriterion("last_upd_user <>", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserGreaterThan(String value) {
            addCriterion("last_upd_user >", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserGreaterThanOrEqualTo(String value) {
            addCriterion("last_upd_user >=", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLessThan(String value) {
            addCriterion("last_upd_user <", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLessThanOrEqualTo(String value) {
            addCriterion("last_upd_user <=", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserLike(String value) {
            addCriterion("last_upd_user like", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotLike(String value) {
            addCriterion("last_upd_user not like", value, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserIn(List<String> values) {
            addCriterion("last_upd_user in", values, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotIn(List<String> values) {
            addCriterion("last_upd_user not in", values, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserBetween(String value1, String value2) {
            addCriterion("last_upd_user between", value1, value2, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdUserNotBetween(String value1, String value2) {
            addCriterion("last_upd_user not between", value1, value2, "lastUpdUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIsNull() {
            addCriterion("last_upd_dtime is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIsNotNull() {
            addCriterion("last_upd_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime =", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <>", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("last_upd_dtime >", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime >=", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeLessThan(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_upd_dtime <=", value, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeIn(List<Date> values) {
            addCriterionForJDBCDate("last_upd_dtime in", values, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_upd_dtime not in", values, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_upd_dtime between", value1, value2, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andLastUpdDtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_upd_dtime not between", value1, value2, "lastUpdDtime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Integer value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Integer value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Integer value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Integer value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Integer> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Integer> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmt_ap_stat
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}