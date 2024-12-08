package judgels.michael.problem.programming.grading.config;

import java.util.List;
import java.util.Optional;
import judgels.fs.FileInfo;
import judgels.gabriel.api.GradingConfig;
import judgels.gabriel.api.TestGroup;
import judgels.gabriel.engines.outputonly.OutputOnlyGradingConfig;

public class OutputOnlyGradingConfigAdapter extends BaseGradingConfigAdapter {
    @Override
    public GradingConfigForm buildFormFromConfig(GradingConfig config) {
        GradingConfigForm form = new GradingConfigForm();
        fillTestDataWithoutSubtasksFormPartsFromConfig(form, config);

        OutputOnlyGradingConfig castConfig = (OutputOnlyGradingConfig) config;
        fillCustomScorerFormPartFromConfig(form, castConfig.getCustomScorer());

        return form;
    }

    @Override
    public GradingConfig buildConfigFromForm(GradingConfigForm form) {
        List<TestGroup> testDataPart = getTestDataWithoutSubtasksConfigPartsFromForm(form);
        Optional<String> customScorerPart = getCustomScorerConfigPartFromForm(form);

        return new OutputOnlyGradingConfig.Builder()
                .testData(testDataPart)
                .customScorer(customScorerPart)
                .build();
    }

    @Override
    public GradingConfig autoPopulateTestData(GradingConfig config, List<FileInfo> testDataFiles) {
        return new OutputOnlyGradingConfig.Builder()
                .from(config)
                .testData(autoPopulateTestDataByFilename(testDataFiles))
                .build();
    }
}
