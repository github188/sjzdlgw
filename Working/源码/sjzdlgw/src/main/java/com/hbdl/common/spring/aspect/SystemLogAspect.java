//package com.hbdl.common.spring.aspect;
//
//import java.lang.reflect.Method;
//import java.util.Date;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import com.hbdl.common.constant.Constant;
//import com.hbdl.common.spring.annotation.Log;
//import com.hbdl.common.spring.annotation.LogType;
//import com.hbdl.common.utils.IPUtils;
//import com.hbdl.common.utils.PMSUtils;
//import com.hbdl.web.sys.model.SysLog;
//import com.hbdl.web.sys.model.SysUser;
//import com.hbdl.web.sys.service.SysLogService;
//import com.hbdl.web.sys.utils.SysUserUtils;
//
//@Aspect
//@Component
//@Order(0)
//public class SystemLogAspect {
//
//	@Resource
//	private SysLogService sysLogService;
//
//	// 本地异常日志记录对象
//	private final static Logger LOGGER = LoggerFactory.getLogger(SystemLogAspect.class);
//
//	@Pointcut("@annotation(com.hbdl.common.spring.annotation.Log)")
//	public void accessAspect() {
//	}
//
//	@Pointcut("execution(* com.hbdl.web..*Service.*(..))")
//	public void throwingAspect() {
//	}
//
//	@AfterReturning(value = "accessAspect()", returning = "rtv")
//	public void doAfterReturning(JoinPoint joinPoint, Object rtv) {
//		saveLog(joinPoint, null);
//	}
//
//	@AfterThrowing(value = "throwingAspect()", throwing = "e")
//	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
//		saveLog(joinPoint, e);
//	}
//
//	protected void saveLog(JoinPoint joinPoint, Throwable e) {
//		try {
//			HttpServletRequest request = SysUserUtils.getCurRequest();
//			SysLog log = new SysLog();
//			// 判断参数
//			if (joinPoint.getArgs() != null) {
//				StringBuffer rs = new StringBuffer();
//				for (int i = 0, len = joinPoint.getArgs().length; i < len; i++) {
//					Object info = joinPoint.getArgs()[i];
//					if (info != null) {
//						String paramType = info.getClass().getSimpleName();
//						rs.append("[参数" + (i + 1) + "，类型:" + paramType + "，值:" + info.toString() + "]");
//					} else {
//						rs.append("[参数" + (i + 1) + "，值:null]");
//					}
//				}
//				log.setParams(rs.toString());
//			}
//			Method m = ((MethodSignature) joinPoint.getSignature()).getMethod();
//			Log sclog = m.getAnnotation(Log.class);
//			if (sclog != null) {
//				SysUser sysUser = (SysUser) SysUserUtils.getSession().getAttribute(Constant.SESSION_LOGIN_USER);
//
//				log.setTitle(sclog.description());
//				log.setRemote_ip(IPUtils.getClientAddress(request));
//				log.setCreate_by(sysUser.getLogin_name());
//				log.setCreate_date(new Date());
//				log.setMethod(m.getName());
//
//				if (sclog.type().equals(LogType.OPERATE)) {
//					log.setType(e == null ? SysLog.TYPE_ACCESS : SysLog.TYPE_EXCEPTION);
//				} else if (sclog.type().equals(LogType.LOGIN)) {
//					log.setType(e == null ? SysLog.TYPE_LOGIN : SysLog.TYPE_EXCEPTION);
//				}
//			}
//			if (e != null) {
//				log.setType(SysLog.TYPE_EXCEPTION);
//				log.setTitle("操作异常");
//			}
//			// log保存到数据库
//			log.setLog_uuid(PMSUtils.getUUID());
//			sysLogService.insertSelective(log);
//		} catch (Exception ex) {
//			LOGGER.error(ex.getMessage());
//		}
//	}
//
//}
