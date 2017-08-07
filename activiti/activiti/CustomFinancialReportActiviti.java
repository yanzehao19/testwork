package activiti;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 根据activiti官方提供的 编写 1.财务部门填写月财务报告 2.股东审核月财务审计报告
 * 
 * 
 * activiti提供的财务报告审核 <!-- 采用用户组为accountancy编写财务报告 -->
 * <userTask id="usertask1" name="财务编写月财务报告" activiti:candidateGroups=
 * "accountancy"></userTask> <!-- 采用用户组为management编写财务报告 -->
 * <userTask id="usertask2" name="股东审核月财务审计报告" activiti:candidateGroups=
 * "management"></userTask>
 * 
 * 备注： 默认的两个用户：
 * 
 * <pre>
 *  
*       用户名   密码         用户组  
       Table 2.1. The demo users 
       UserId Password Security roles  
       kermit kermit admin  
       gonzo gonzo manager  
       fozzie fozzie user
 * </pre>
 * 
 * @author longgangbai
 * 
 *         2011-12-18 下午04:08:46
 */

public class CustomFinancialReportActiviti {

	public static void main(String[] args) {
		// Create Activiti process engine
		// 创建一个流程引擎对象
		// ProcessEngine processEngine = ProcessEngineConfiguration
		// .createStandaloneProcessEngineConfiguration()
		// .buildProcessEngine();

		// 创建一个流程引擎对象（为了便于多册测试，修改 name="databaseSchemaUpdate"
		// value="create-drop" 默认为ture）

		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();

		// Get Activiti services
		// 获得流程相关的服务
		RepositoryService repositoryService = processEngine.getRepositoryService();

		RuntimeService runtimeService = processEngine.getRuntimeService();

		// Deploy the process definition
		// 部署相关的流程配置

		repositoryService.createDeployment().addClasspathResource("financialReport.bpmn20.xml").deploy();
		// Start a process instance
		// 获取流程实例
		String procId = runtimeService.startProcessInstanceByKey("fianncialReport").getId();
		// get the first task
		TaskService taskService = processEngine.getTaskService();
		// 获取accountancy组可能要操作的任务
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
		for (Task task : tasks) {
			System.out.println("Following task is available for accountancy group: " + task.getName());
			// 设置fozzie代办 claim it
			taskService.claim(task.getId(), "fozzie");
		}
		// Verify Fozzie can now retrieve the task
		// 审核fozzie当前的获取的任务数量
		tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();
		for (Task task : tasks) {
			System.out.println("Task for fozzie: " + task.getName());

			// Complete the task
			// 设置forzze完毕
			taskService.complete(task.getId());
		}
		System.out
				.println("Number of tasks for fozzie: " + taskService.createTaskQuery().taskAssignee("fozzie").count());

		// Retrieve and claim the second task
		// 管理者审核报告并让kermit代办
		tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		for (Task task : tasks) {
			System.out.println("Following task is available for accountancy group: " + task.getName());
			taskService.claim(task.getId(), "kermit");
		}

		// Completing the second task ends the process
		// 完成报告
		for (Task task : tasks) {
			taskService.complete(task.getId());
		}

		HistoryService historyService = processEngine.getHistoryService();
		HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(procId).singleResult();
		System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
	}

}
