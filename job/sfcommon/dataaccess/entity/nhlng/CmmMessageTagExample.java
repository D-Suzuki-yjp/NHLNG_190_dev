package job.sfcommon.dataaccess.entity.nhlng;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.Dependent;

@Dependent
public class CmmMessageTagExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    protected Criteria criteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public CmmMessageTagExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
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
     * This method corresponds to the database table public.cmm_message_tag
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
     * This method corresponds to the database table public.cmm_message_tag
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_message_tag
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
     * This class corresponds to the database table public.cmm_message_tag
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNull() {
            addCriterion("seq_no is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("seq_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Integer value) {
            addCriterion("seq_no =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Integer value) {
            addCriterion("seq_no <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Integer value) {
            addCriterion("seq_no >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_no >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Integer value) {
            addCriterion("seq_no <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
            addCriterion("seq_no <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Integer> values) {
            addCriterion("seq_no in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Integer> values) {
            addCriterion("seq_no not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Integer value1, Integer value2) {
            addCriterion("seq_no between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_no not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andTagNoIsNull() {
            addCriterion("tag_no is null");
            return (Criteria) this;
        }

        public Criteria andTagNoIsNotNull() {
            addCriterion("tag_no is not null");
            return (Criteria) this;
        }

        public Criteria andTagNoEqualTo(String value) {
            addCriterion("tag_no =", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotEqualTo(String value) {
            addCriterion("tag_no <>", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoGreaterThan(String value) {
            addCriterion("tag_no >", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoGreaterThanOrEqualTo(String value) {
            addCriterion("tag_no >=", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLessThan(String value) {
            addCriterion("tag_no <", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLessThanOrEqualTo(String value) {
            addCriterion("tag_no <=", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoLike(String value) {
            addCriterion("tag_no like", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotLike(String value) {
            addCriterion("tag_no not like", value, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoIn(List<String> values) {
            addCriterion("tag_no in", values, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotIn(List<String> values) {
            addCriterion("tag_no not in", values, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoBetween(String value1, String value2) {
            addCriterion("tag_no between", value1, value2, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagNoNotBetween(String value1, String value2) {
            addCriterion("tag_no not between", value1, value2, "tagNo");
            return (Criteria) this;
        }

        public Criteria andTagValIsNull() {
            addCriterion("tag_val is null");
            return (Criteria) this;
        }

        public Criteria andTagValIsNotNull() {
            addCriterion("tag_val is not null");
            return (Criteria) this;
        }

        public Criteria andTagValEqualTo(BigDecimal value) {
            addCriterion("tag_val =", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValNotEqualTo(BigDecimal value) {
            addCriterion("tag_val <>", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValGreaterThan(BigDecimal value) {
            addCriterion("tag_val >", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tag_val >=", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValLessThan(BigDecimal value) {
            addCriterion("tag_val <", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tag_val <=", value, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValIn(List<BigDecimal> values) {
            addCriterion("tag_val in", values, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValNotIn(List<BigDecimal> values) {
            addCriterion("tag_val not in", values, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tag_val between", value1, value2, "tagVal");
            return (Criteria) this;
        }

        public Criteria andTagValNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tag_val not between", value1, value2, "tagVal");
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
     * This class corresponds to the database table public.cmm_message_tag
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
     * This class corresponds to the database table public.cmm_message_tag
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