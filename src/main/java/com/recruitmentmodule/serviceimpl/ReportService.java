package com.recruitmentmodule.serviceimpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.recruitmentmodule.model.JobCandidate;
import com.recruitmentmodule.model.JobPost;
import com.recruitmentmodule.model.ScheduleJobInterview;
import com.recruitmentmodule.repository.JobCandidatesRepository;
import com.recruitmentmodule.repository.JobPostRepository;
import com.recruitmentmodule.repository.ScheduleJobInterviewRepository;
import com.recruitmentmodule.utils.Constants;
import com.recruitmentmodule.utils.DateUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private JobPostRepository jobPostRepo;

	@Autowired
	private JobCandidatesRepository candidatesRepo;

	@Autowired
	private ScheduleJobInterviewRepository interviewRepository;

	// job post services
	public String jobPostPdfReport() throws FileNotFoundException, JRException {

		List<JobPost> post = jobPostRepo.findAll();
		// load file and compile it

		File file = ResourceUtils.getFile("classpath:JobPost.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(post);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Akshay");
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String home = System.getProperty("user.home");
		String fileName = "User" + timeStamp + ".pdf";
		JasperExportManager.exportReportToPdfFile(jasperprint, home + "\\Downloads\\" + fileName);

		return "report generated in path :" + home;
	}

	public void jobPostCSVReport(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String fileName = "User" + timeStamp + ".csv";

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;

		response.setHeader(headerKey, headerValue);
		List<JobPost> post = jobPostRepo.findAll();

		ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "company", "jobTitle", "jobCategory", "dateOfClosing", "status" };
		String[] nameMapping = { "company", "jobTitle", "jobCategory", "dateOfClosing", "status" };
		beanWriter.writeHeader(csvHeader);

		for (JobPost job : post) {
			beanWriter.write(job, nameMapping);
		}
		beanWriter.close();
	}

	// job candidate services
	public String jobCandidatePdfReport() throws FileNotFoundException, JRException {

		List<JobCandidate> post = candidatesRepo.findAll();
		// load file and compile it

		File file = ResourceUtils.getFile("classpath:JobCandidate.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(post);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Akshay");
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String home = System.getProperty("user.home");
		String fileName = "Candidate" + timeStamp + ".pdf";
		JasperExportManager.exportReportToPdfFile(jasperprint, home + "\\Downloads\\" + fileName);

		return "report generated in path :" + home;
	}

	public void jobCandidateCSVReport(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String fileName = "Candidate" + timeStamp + ".csv";

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;

		response.setHeader(headerKey, headerValue);
		List<JobCandidate> post = candidatesRepo.findAll();

		ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "jobTitle", "candidateName", "email", "status", "applyDate" };
		String[] nameMapping = { "jobTitle", "candidateName", "email", "status", "applyDate" };
		beanWriter.writeHeader(csvHeader);

		for (JobCandidate job : post) {
			beanWriter.write(job, nameMapping);
		}
		beanWriter.close();
	}

	// ScheduleJobInterview services
	public String ScheduleInterviewPdfReport() throws FileNotFoundException, JRException {

		List<ScheduleJobInterview> post = interviewRepository.findAll();
		// load file and compile it

		File file = ResourceUtils.getFile("classpath:ScheduleJobInterview.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(post);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Created by", "Akshay");
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String home = System.getProperty("user.home");
		String fileName = "Interview" + timeStamp + ".pdf";
		JasperExportManager.exportReportToPdfFile(jasperprint, home + "\\Downloads\\" + fileName);

		return "report generated in path :" + home;
	}

	public void ScheduleInterviewCSVReport(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		String timeStamp = DateUtils.timeStamp(Constants.FILE_SUFFIX_DATE_FORMAT);
		String fileName = "Candidate" + timeStamp + ".csv";

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;

		response.setHeader(headerKey, headerValue);
		List<ScheduleJobInterview> post = interviewRepository.findAll();

		ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "jobTitle", "candidate", "interviewPlace", "interviewDate", "interviewer" };
		String[] nameMapping = { "jobTitle", "candidate", "interviewPlace", "interviewDate", "interviewer" };
		beanWriter.writeHeader(csvHeader);

		for (ScheduleJobInterview interview : post) {
			beanWriter.write(interview, nameMapping);
		}
		beanWriter.close();
	}

}
