package job.common.nhlngCommon.dataAccess.entity.nhlng;

import java.util.ArrayList;
import java.util.List;

public class CmmInputExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    protected Criteria criteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public CmmInputExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
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
     * This method corresponds to the database table public.cmm_input
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
     * This method corresponds to the database table public.cmm_input
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.cmm_input
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
     * This class corresponds to the database table public.cmm_input
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

        public Criteria andHistoryKindIsNull() {
            addCriterion("history_kind is null");
            return (Criteria) this;
        }

        public Criteria andHistoryKindIsNotNull() {
            addCriterion("history_kind is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryKindEqualTo(Integer value) {
            addCriterion("history_kind =", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindNotEqualTo(Integer value) {
            addCriterion("history_kind <>", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindGreaterThan(Integer value) {
            addCriterion("history_kind >", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_kind >=", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindLessThan(Integer value) {
            addCriterion("history_kind <", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindLessThanOrEqualTo(Integer value) {
            addCriterion("history_kind <=", value, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindIn(List<Integer> values) {
            addCriterion("history_kind in", values, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindNotIn(List<Integer> values) {
            addCriterion("history_kind not in", values, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindBetween(Integer value1, Integer value2) {
            addCriterion("history_kind between", value1, value2, "historyKind");
            return (Criteria) this;
        }

        public Criteria andHistoryKindNotBetween(Integer value1, Integer value2) {
            addCriterion("history_kind not between", value1, value2, "historyKind");
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

        public Criteria andInputTypeIsNull() {
            addCriterion("input_type is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("input_type is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(Integer value) {
            addCriterion("input_type =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(Integer value) {
            addCriterion("input_type <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(Integer value) {
            addCriterion("input_type >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("input_type >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(Integer value) {
            addCriterion("input_type <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(Integer value) {
            addCriterion("input_type <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<Integer> values) {
            addCriterion("input_type in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<Integer> values) {
            addCriterion("input_type not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(Integer value1, Integer value2) {
            addCriterion("input_type between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("input_type not between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTagNoIsNull() {
            addCriterion("input_tag_no is null");
            return (Criteria) this;
        }

        public Criteria andInputTagNoIsNotNull() {
            addCriterion("input_tag_no is not null");
            return (Criteria) this;
        }

        public Criteria andInputTagNoEqualTo(String value) {
            addCriterion("input_tag_no =", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoNotEqualTo(String value) {
            addCriterion("input_tag_no <>", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoGreaterThan(String value) {
            addCriterion("input_tag_no >", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoGreaterThanOrEqualTo(String value) {
            addCriterion("input_tag_no >=", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoLessThan(String value) {
            addCriterion("input_tag_no <", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoLessThanOrEqualTo(String value) {
            addCriterion("input_tag_no <=", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoLike(String value) {
            addCriterion("input_tag_no like", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoNotLike(String value) {
            addCriterion("input_tag_no not like", value, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoIn(List<String> values) {
            addCriterion("input_tag_no in", values, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoNotIn(List<String> values) {
            addCriterion("input_tag_no not in", values, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoBetween(String value1, String value2) {
            addCriterion("input_tag_no between", value1, value2, "inputTagNo");
            return (Criteria) this;
        }

        public Criteria andInputTagNoNotBetween(String value1, String value2) {
            addCriterion("input_tag_no not between", value1, value2, "inputTagNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.cmm_input
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
     * This class corresponds to the database table public.cmm_input
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