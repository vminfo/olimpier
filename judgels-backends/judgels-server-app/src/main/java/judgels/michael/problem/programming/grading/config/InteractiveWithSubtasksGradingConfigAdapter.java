package judgels.michael.problem.programming.grading.config;

import java.util.List;
import java.util.Optional;
import judgels.fs.FileInfo;
import judgels.gabriel.api.GradingConfig;
import judgels.gabriel.api.TestGroup;
import judgels.gabriel.engines.interactive.InteractiveWithSubtasksGradingConfig;

public class InteractiveWithSubtasksGradingConfigAdapter extends BaseGradingConfigAdapter {
    @Override
    public GradingConfigForm buildFormFromConfig(GradingConfig config) {
        GradingConfigForm form = new GradingConfigForm();
        fillLimitsFormPartsFromConfig(form, config);
        fillTestDataWithSubtasksFormPartsFromConfig(form, config);

        InteractiveWithSubtasksGradingConfig castConfig = (InteractiveWithSubtasksGradingConfig) config;
        fillCommunicatorFormPartFromConfig(form, castConfig.getCommunicator());

        return form;
    }

    @Override
    @SuppressWarnings("unchecked")
    public GradingConfig buildConfigFromForm(GradingConfigForm form) {
        Object[] limitParts = getLimitsConfigPartsFromForm(form);
        Object[] testDataParts = getTestDataWithSubtasksConfigPartsFromForm(form);
        Optional<String> communicatorPart = getCommunicatorConfigPartFromForm(form);

        return new InteractiveWithSubtasksGradingConfig.Builder()
                .timeLimit((int) limitParts[0])
                .memoryLimit((int) limitParts[1])
                .testData((List<TestGroup>) testDataParts[0])
                .subtaskPoints((List<Integer>) testDataParts[1])
                .communicator(communicatorPart)
                .build();
    }

    @Override
    @SuppressWarnings("unchecked")
    public GradingConfig autoPopulateTestData(GradingConfig config, List<FileInfo> testDataFiles) {
        Object[] parts = autoPopulateTestDataByTCFrameFormat(false, config.getSubtasks(), testDataFiles);

        return new InteractiveWithSubtasksGradingConfig.Builder()
                .from(config)
                .testData((List<TestGroup>) parts[0])
                .subtaskPoints((List<Integer>) parts[1])
                .build();
    }
}
