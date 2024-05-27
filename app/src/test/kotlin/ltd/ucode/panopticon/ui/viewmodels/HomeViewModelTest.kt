package ltd.ucode.panopticon.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ltd.ucode.panopticon.domain.usecases.GetPictures
import ltd.ucode.panopticon.ui.models.Data
import ltd.ucode.panopticon.ui.models.Error
import ltd.ucode.panopticon.utils.CoroutinesTestRule
import ltd.ucode.panopticon.utils.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HomeViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `check case when init view model`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } returns emptyList()

        val viewModel = HomeViewModel(userCase)

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Data(emptyList())))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `check when init fail with exception`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } throws Exception()

        val viewModel = HomeViewModel(userCase)

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Error))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `check case with retry`() = runBlockingTest {

        val userCase = mockk<GetPictures>()

        coEvery { userCase() } returns emptyList()

        val viewModel = HomeViewModel(userCase)

        viewModel.retry()

        assertThat(viewModel.state.getOrAwaitValue(), IsEqual(Data(emptyList())))
    }

}
