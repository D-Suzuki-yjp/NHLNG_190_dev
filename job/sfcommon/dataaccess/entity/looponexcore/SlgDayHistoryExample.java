package job.sfcommon.dataaccess.entity.looponexcore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;

@Dependent
public class SlgDayHistoryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public SlgDayHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
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
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.slg_day_history
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
     * This class corresponds to the database table public.slg_day_history
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

        public Criteria andHistoryDateIsNull() {
            addCriterion("history_date is null");
            return (Criteria) this;
        }

        public Criteria andHistoryDateIsNotNull() {
            addCriterion("history_date is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryDateEqualTo(Date value) {
            addCriterion("history_date =", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateNotEqualTo(Date value) {
            addCriterion("history_date <>", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateGreaterThan(Date value) {
            addCriterion("history_date >", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("history_date >=", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateLessThan(Date value) {
            addCriterion("history_date <", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateLessThanOrEqualTo(Date value) {
            addCriterion("history_date <=", value, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateIn(List<Date> values) {
            addCriterion("history_date in", values, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateNotIn(List<Date> values) {
            addCriterion("history_date not in", values, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateBetween(Date value1, Date value2) {
            addCriterion("history_date between", value1, value2, "historyDate");
            return (Criteria) this;
        }

        public Criteria andHistoryDateNotBetween(Date value1, Date value2) {
            addCriterion("history_date not between", value1, value2, "historyDate");
            return (Criteria) this;
        }

        public Criteria andLcodeIsNull() {
            addCriterion("lcode is null");
            return (Criteria) this;
        }

        public Criteria andLcodeIsNotNull() {
            addCriterion("lcode is not null");
            return (Criteria) this;
        }

        public Criteria andLcodeEqualTo(String value) {
            addCriterion("lcode =", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotEqualTo(String value) {
            addCriterion("lcode <>", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeGreaterThan(String value) {
            addCriterion("lcode >", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeGreaterThanOrEqualTo(String value) {
            addCriterion("lcode >=", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLessThan(String value) {
            addCriterion("lcode <", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLessThanOrEqualTo(String value) {
            addCriterion("lcode <=", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeLike(String value) {
            addCriterion("lcode like", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotLike(String value) {
            addCriterion("lcode not like", value, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeIn(List<String> values) {
            addCriterion("lcode in", values, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotIn(List<String> values) {
            addCriterion("lcode not in", values, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeBetween(String value1, String value2) {
            addCriterion("lcode between", value1, value2, "lcode");
            return (Criteria) this;
        }

        public Criteria andLcodeNotBetween(String value1, String value2) {
            addCriterion("lcode not between", value1, value2, "lcode");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andQualityIsNull() {
            addCriterion("quality is null");
            return (Criteria) this;
        }

        public Criteria andQualityIsNotNull() {
            addCriterion("quality is not null");
            return (Criteria) this;
        }

        public Criteria andQualityEqualTo(Integer value) {
            addCriterion("quality =", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotEqualTo(Integer value) {
            addCriterion("quality <>", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThan(Integer value) {
            addCriterion("quality >", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quality >=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThan(Integer value) {
            addCriterion("quality <", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityLessThanOrEqualTo(Integer value) {
            addCriterion("quality <=", value, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityIn(List<Integer> values) {
            addCriterion("quality in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotIn(List<Integer> values) {
            addCriterion("quality not in", values, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityBetween(Integer value1, Integer value2) {
            addCriterion("quality between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andQualityNotBetween(Integer value1, Integer value2) {
            addCriterion("quality not between", value1, value2, "quality");
            return (Criteria) this;
        }

        public Criteria andCollectDateIsNull() {
            addCriterion("collect_date is null");
            return (Criteria) this;
        }

        public Criteria andCollectDateIsNotNull() {
            addCriterion("collect_date is not null");
            return (Criteria) this;
        }

        public Criteria andCollectDateEqualTo(Date value) {
            addCriterion("collect_date =", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotEqualTo(Date value) {
            addCriterion("collect_date <>", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateGreaterThan(Date value) {
            addCriterion("collect_date >", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_date >=", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateLessThan(Date value) {
            addCriterion("collect_date <", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateLessThanOrEqualTo(Date value) {
            addCriterion("collect_date <=", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateIn(List<Date> values) {
            addCriterion("collect_date in", values, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotIn(List<Date> values) {
            addCriterion("collect_date not in", values, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateBetween(Date value1, Date value2) {
            addCriterion("collect_date between", value1, value2, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotBetween(Date value1, Date value2) {
            addCriterion("collect_date not between", value1, value2, "collectDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.slg_day_history
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
     * This class corresponds to the database table public.slg_day_history
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